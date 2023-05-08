package Exception;

import java.io.IOException;

public class WithoutDataSavedGsonReaderException extends IOException {
    public WithoutDataSavedGsonReaderException() {
        System.err.println("No data saved yet");
    }
}
