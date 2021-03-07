package logs;

import transition.Move;

import java.util.ArrayList;
import java.util.List;

public class MoveLog {


    private enum RecordStatus {
        STORED, REMOVED
    }

    private static final class MoveRecord {
        private Move move;
        private RecordStatus recordStatus;

        private MoveRecord(final Move move, final RecordStatus recordStatus) {
            this.recordStatus = recordStatus;
            this.move = move;
        }

        @Override
        public String toString() {
            return "move=" + move +
                    ", recordStatus=" + recordStatus +
                    "\n";
        }
    }

    private static final List<MoveRecord> movesLog = new ArrayList<>();

    public static List<MoveRecord> getMovesLog() {
        return movesLog;
    }

    public static void addLog(Move move) {
        movesLog.add(new MoveRecord(move, RecordStatus.STORED));
    }

    public static void removeLastRecord() {
        movesLog.get(movesLog.size() - 1).recordStatus = RecordStatus.REMOVED;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
