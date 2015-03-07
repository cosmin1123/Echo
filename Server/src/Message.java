import java.io.Serializable;

/**
 * Created by Vlad on 3/7/2015.
 */
public class Message implements Serializable{

    String deviceIdentifier;
    Integer uniqueIdentifier;
    String text;
    boolean isAnswer;

    Message(String deviceIdentifier, Integer uniqueIdentifier, String text, boolean isAnswer){
        this.deviceIdentifier = deviceIdentifier;
        this.uniqueIdentifier = uniqueIdentifier;
        this.text = text;
        this.isAnswer = isAnswer;
    }

    boolean equals(Message m)
    {
        return deviceIdentifier.equals(m.deviceIdentifier)
                && uniqueIdentifier.equals(m.uniqueIdentifier)
                && text.equals(m.text)
                && (isAnswer == m.isAnswer);
    }
}
