import android.graphics.ImageFormat
import android.util.Log
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.zxing.*
import com.google.zxing.common.HybridBinarizer
import java.nio.ByteBuffer

class QrCodeAnalyzer2(
    private val onQrCodeScanned: (String) -> Unit
) : ImageAnalysis.Analyzer {

    private val reader = MultiFormatReader().apply {
        setHints(
            mapOf(
                DecodeHintType.POSSIBLE_FORMATS to listOf(BarcodeFormat.QR_CODE),
                DecodeHintType.TRY_HARDER to true // Makes ZXing work harder to find QR codes
            )
        )
    }

    override fun analyze(image: ImageProxy) {
        try {
            if (image.format != ImageFormat.YUV_420_888) {
                Log.e("QrCodeAnalyzer", "Unsupported image format: ${image.format}")
                image.close()
                return
            }

            val buffer = image.planes[0].buffer
            val data = ByteArray(buffer.remaining())
            buffer.get(data)

            val width = image.width
            val height = image.height

            // Rotate image if necessary
            val rotatedData = rotateYUV420(data, width, height, image.imageInfo.rotationDegrees)

            val source = PlanarYUVLuminanceSource(
                rotatedData, width, height,
                0, 0, width, height, false
            )

            val binaryBitmap = BinaryBitmap(HybridBinarizer(source))

            val result = reader.decode(binaryBitmap)
            onQrCodeScanned(result.text) // Successfully found QR code

        } catch (e: NotFoundException) {
            Log.e("QrCodeAnalyzer", "QR Code not found in the frame")
        } catch (e: Exception) {
            Log.e("QrCodeAnalyzer", "Error analyzing QR code", e)
        } finally {
            image.close() // Always close image to avoid memory leaks
        }
    }

    private fun rotateYUV420(data: ByteArray, width: Int, height: Int, rotationDegrees: Int): ByteArray {
        return if (rotationDegrees == 90 || rotationDegrees == 270) {
            val rotatedData = ByteArray(data.size)
            for (y in 0 until height) {
                for (x in 0 until width) {
                    rotatedData[x * height + height - y - 1] = data[x + y * width]
                }
            }
            rotatedData
        } else {
            data
        }
    }
}
