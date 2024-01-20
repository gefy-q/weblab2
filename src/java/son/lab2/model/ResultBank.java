package son.lab2.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class ResultBank {
    private final Deque<CheckResult> data;
    public ResultBank () {
        data = new ArrayDeque<>();
    }
    public Deque<CheckResult> getData() {
        return data;
    }
    public void addResult(CheckResult result) {
        data.add(result);
    }
}
