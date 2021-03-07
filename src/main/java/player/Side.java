package player;

public enum Side {

    X {
        @Override
        public boolean isX() {
            return true;
        }

        @Override
        public String symbol() {
            return "X";
        }
    }, O {
        @Override
        public boolean isX() {
            return false;
        }

        @Override
        public String symbol() {
            return "O";
        }
    };

    public abstract boolean isX();
    public abstract String symbol();
}
