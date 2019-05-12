import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class ListModel extends AbstractListModel<String> {
  private static final long serialVersionUID = 4538573110794606552L;
  ArrayList<String> list;

  public ListModel(ArrayList<String> list) {
    this.list = list;
    this.fireIntervalAdded(this, 0, this.getSize());
  }

  public ListModel() {
    this.list = new ArrayList<String>();
  }

  public boolean add(String s) {
    if (this.list.contains(s)) {
      return false;
    }

    boolean added = this.list.add(s);
    this.fireIntervalAdded(this, 0, this.getSize());
    return added;
  }

  public boolean remove(String stringToRemove) {
    boolean removed = this.list.removeIf(s -> s.equals(stringToRemove));
    this.fireIntervalRemoved(this, 0, this.getSize());
    return removed;
  }

  @Override
  public int getSize() {
    return this.list.size();
  }

  @Override
  public String getElementAt(int index) {
    return this.list.get(index);
  }
}
