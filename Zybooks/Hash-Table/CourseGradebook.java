import java.util.ArrayList;
import java.util.HashMap;

public class CourseGradebook extends Gradebook {
    // Fields to store gradebook data
    private HashMap<String, HashMap<Integer, Double>> assignmentScores = new HashMap<>();
    private HashMap<Integer, HashMap<String, Double>> studentScores = new HashMap<>();
    private ArrayList<String> assignmentNames = new ArrayList<>();
    private ArrayList<Integer> studentIDs = new ArrayList<>();

    @Override
    public double getScore(String assignmentName, Integer studentID) {
        if (assignmentScores.containsKey(assignmentName)) {
            HashMap<Integer, Double> scores = assignmentScores.get(assignmentName);
            if (scores.containsKey(studentID)) {
                return scores.get(studentID);
            }
        }
        return Double.NaN; // No such assignment or student ID
    }

    @Override
    public void setScore(String assignmentName, Integer studentID, Double score) {
        // Ensure assignment name is not empty
        if (assignmentName == null || assignmentName.isEmpty()) {
            throw new IllegalArgumentException("Assignment name cannot be empty");
        }

        // Ensure student ID is not null
        if (studentID == null) {
            throw new IllegalArgumentException("Student ID cannot be null");
        }

        // Ensure score is not null
        if (score == null) {
            throw new IllegalArgumentException("Score cannot be null");
        }

        // Ensure assignment name is in the list of assignment names
        if (!assignmentNames.contains(assignmentName)) {
            assignmentNames.add(assignmentName);
        }

        // Ensure student ID is in the list of student IDs
        if (!studentIDs.contains(studentID)) {
            studentIDs.add(studentID);
        }

        // Update assignmentScores
        assignmentScores.computeIfAbsent(assignmentName, k -> new HashMap<>()).put(studentID, score);

        // Update studentScores
        studentScores.computeIfAbsent(studentID, k -> new HashMap<>()).put(assignmentName, score);
    }

    @Override
    public HashMap<Integer, Double> getAssignmentScores(String assignmentName) {
        return assignmentScores.getOrDefault(assignmentName, new HashMap<>());
    }

    @Override
    public ArrayList<String> getSortedAssignmentNames() {
        assignmentNames.sort(String::compareTo);
        return assignmentNames;
    }

    @Override
    public ArrayList<Integer> getSortedStudentIDs() {
        studentIDs.sort(Integer::compareTo);
        return studentIDs;
    }

    @Override
    public HashMap<String, Double> getStudentScores(Integer studentID) {
        return studentScores.getOrDefault(studentID, new HashMap<>());
    }
}
