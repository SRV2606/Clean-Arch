import android.os.Parcelable
import com.example.data.serverModels.ResponseUser
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseClosedPrs(
    @SerializedName("created_at")
    var createdAt: String? = "",
    @SerializedName("updated_at")
    var updatedAt: String? = "",
    @SerializedName("title")
    var title: String? = "",
    @SerializedName("user")
    var user: ResponseUser? = null
) : Parcelable

