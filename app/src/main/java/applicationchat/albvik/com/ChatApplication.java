package applicationchat.albvik.com;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import model.Message;

/**
 * Created by albvik on 1/26/2017.
 */

public class ChatApplication extends Application{
    public static final String APP_KEY_ID="gxovB3ZqLxYbCgzIWBH633fqYR053Bdb57wzXjBg";
    public static final String APP_ID_PASSWORD="SU2oLfhTzAhVlvlk60c4IQRUC3vBmxoitW5F3Jjo";

    @Override
    public void onCreate(){
        super.onCreate();
        ParseObject.registerSubclass(Message.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(APP_KEY_ID)
                .clientKey(APP_ID_PASSWORD)
                .server("https://parseapi.back4app.com/").build()
        );
    }
}
