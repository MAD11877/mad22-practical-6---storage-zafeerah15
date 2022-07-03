package sg.edu.np.edu.mad.s10205175_week2practical;

import android.os.Parcelable;

import java.io.Serializable;

public class userclass implements Serializable {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public userclass(String _name, String _description, int _id,boolean _followed){
        name = _name;
        description = _description;
        id = _id;
        followed = _followed;
    }
}
