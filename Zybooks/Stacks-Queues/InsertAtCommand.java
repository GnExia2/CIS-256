import java.util.ArrayList;

public class InsertAtCommand extends UndoCommand {
	// Your field declarations here
    private ArrayList<String> sourceList;
    private int index;
    private String item;

	// Your constructor code here
    public InsertAtCommand(ArrayList<String> lst, int idx, String itm) {
        this.sourceList = lst;
        this.index = idx;
        this.item = itm;
    }

	
	@Override
	public void execute() {
        if (index >= 0 && index <= sourceList.size()) {
            sourceList.add(index, item);
        } else {
            System.out.println("Invalid index for insert");
        }
	}
}
