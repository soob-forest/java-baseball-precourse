package baseball.enums;

public enum EndOrContinueStatus {
    CONTINUE(1),
    END(2);

    private int statusCode;

    EndOrContinueStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean equals(int target) {
        return this.statusCode == target;
    }
    
}
