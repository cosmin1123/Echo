import java.util.LinkedList;

/**
 * Created by Vlad on 3/7/2015.
 */

public class Database {

    LinkedList<Message> questions = new LinkedList<Message>();
    LinkedList<Message> answers = new LinkedList<Message>();
    LinkedList<ConnectedUser> connectedUsers = new LinkedList<ConnectedUser>();

    boolean isUserOnline(String uniqueIdentifier){
        for(ConnectedUser cu : connectedUsers){
            if (cu.deviceIdentifier.equals(uniqueIdentifier)){
                return true;
            }
        }
        return false;
    }

    Message getNextQuestion()
    {
        return questions.getFirst();
    }

    void addQuestion(Message message)
    {
        questions.add(message);
    }

    void removeQuestion(Message message){
        for(Message q : questions){
            if (q.equals(message)){
                connectedUsers.remove(q);
                break;
            }
        }
    }

    void addUser(ConnectedUser connectedUser){
        connectedUsers.add(connectedUser);
    }

    void removeConnectedUser(String uniqueIdentifier){
        for(ConnectedUser cu : connectedUsers){
            if (cu.deviceIdentifier.equals(uniqueIdentifier)){
                connectedUsers.remove(cu);
                break;
            }
        }
    }

    LinkedList<Message> getUserAnsweredQuestions(String uniqueIdentifier){
        LinkedList<Message> res = new LinkedList<Message>();
        for(Message m : answers){
            if (m.deviceIdentifier.equals(uniqueIdentifier)){
                res.add(m);
                answers.remove(m);
            }
        }
        return res;
    }

    void addAnswer(Message message)
    {
        answers.add(message);
    }

    void removeAnswer(Message message){
        for(Message q : answers){
            if (q.equals(message)){
                connectedUsers.remove(q);
                break;
            }
        }
    }
}
