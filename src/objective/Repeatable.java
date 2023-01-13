package objective;

import java.time.LocalDateTime;

public interface Repeatable {

    boolean checkIfSuitable(LocalDateTime time);

    void setName(String name);

    LocalDateTime getTime();


    enum TaskType {
        PRIVATE(0),
        WORK(1);
        public final int type;

        TaskType(int type) {
            this.type = type;
        }
    }
}