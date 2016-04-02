package net.egordmitriev.watchall.pojo.anilist;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by EgorDm on 4/2/2016.
 */
public class ClientCredentials implements Parcelable {
    @SerializedName("access_token")
    public String access_token;
    @SerializedName("token_type")
    public String token_type;
    @SerializedName("expires")
    public Date expires;

    public ClientCredentials(String access_token, Date expires, String token_type) {
        this.access_token = access_token;
        this.expires = expires;
        this.token_type = token_type;
    }

    @Override
    public String toString() {
        return "ClientCredentials{" +
                "access_token='" + access_token + '\'' +
                ", token_type='" + token_type + '\'' +
                ", expires=" + expires +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.access_token);
        dest.writeString(this.token_type);
        dest.writeLong(expires != null ? expires.getTime() : -1);
    }

    protected ClientCredentials(Parcel in) {
        this.access_token = in.readString();
        this.token_type = in.readString();
        long tmpExpires = in.readLong();
        this.expires = tmpExpires == -1 ? null : new Date(tmpExpires);
    }

    public static final Creator<ClientCredentials> CREATOR = new Creator<ClientCredentials>() {
        @Override
        public ClientCredentials createFromParcel(Parcel source) {
            return new ClientCredentials(source);
        }

        @Override
        public ClientCredentials[] newArray(int size) {
            return new ClientCredentials[size];
        }
    };
}