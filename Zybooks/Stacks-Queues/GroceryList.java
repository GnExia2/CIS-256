import java.io.PrintWriter;
import java.util.*;

public class GroceryList {
	protected ArrayList<String> listItems = new ArrayList<String>();
	protected Stack<UndoCommand> undoStack = new Stack<UndoCommand>();

	public void addWithUndo(String newItemName) {
		// Add the new list item
		listItems.add(newItemName);

		// Make an undo command that removes the last item and push onto stack
		undoStack.push(new RemoveLastCommand(listItems));
	}

   public void removeAtWithUndo(int removalIndex) {
       // Check if the removalIndex is valid
       if (removalIndex >= 0 && removalIndex < listItems.size()) {
           // Get the item to be removed
           String removedItem = listItems.get(removalIndex);
   
           // Remove the item from the list
           listItems.remove(removalIndex);
   
           // Push an InsertAtCommand onto the undo stack to undo the removal
           undoStack.push(new InsertAtCommand(listItems, removalIndex, removedItem));
       } else {
           System.out.println("Invalid index for removeat");
       }
   }
   
   public void swapWithUndo(int index1, int index2) {
       // Check if the indices are valid
       if (index1 >= 0 && index1 < listItems.size() && index2 >= 0 && index2 < listItems.size()) {
           // Swap the items at the specified indices
           Collections.swap(listItems, index1, index2);
           
           // Push a SwapCommand onto the undo stack to undo the swap
           undoStack.push(new SwapCommand(listItems, index1, index2));
       } else {
           System.out.println("Invalid indices for swap");
       }
   }
   // Pop and execute the command at the top of the stack
    public void executeUndo() {
        if (!undoStack.isEmpty()) {
            UndoCommand undoCommand = undoStack.pop();
            undoCommand.execute();
        } else {
            System.out.println("Cannot execute undo because undo stack is empty");
        }
    }

	final int getListSize() {
		return listItems.size();
	}

	final int getUndoStackSize() {
		return undoStack.size();
	}

	final ArrayList<String> getVectorCopy() {
		return listItems;
	}

	public void print(PrintWriter outputStream) {
		for (int i = 0; i < listItems.size(); i++) {
			outputStream.write(i + ". " + listItems.get(i) + "\n");
		}
	}
}
