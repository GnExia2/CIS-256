import java.util.*;

public class SwapCommand extends UndoCommand {
   
	// Your field declarations here
    private ArrayList<String> sourceList;
    private int index1;
    private int index2;

	
	// Your constructor code here
	public SwapCommand(ArrayList<String> lst, int i1, int i2) {
      this.sourceList = lst;
      this.index1 = i1;
      this.index2 = i2;
   }

	
	@Override
	public void execute() {
	        if (index1 >= 0 && index1 < sourceList.size() && index2 >= 0 && index2 < sourceList.size()) {
            Collections.swap(sourceList, index1, index2);
        } else {
            System.out.println("Invalid indices for swap");
        }

		// Your code here
	}

}
