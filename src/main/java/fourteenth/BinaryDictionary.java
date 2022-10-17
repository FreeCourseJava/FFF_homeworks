package fourteenth;


import java.util.*;

public class BinaryDictionary<KEY, VALUE> implements Dictionary<KEY, VALUE>, Filterable<VALUE>, Iterable<VALUE> {

    private TreeNode<KEY, VALUE> root, temp;


    @Override
    public VALUE get(KEY key) {
        int hashKey = key.hashCode();
        if (root == null) {
            return null;
        } else {
            temp = root;
        }
        do {
            if (temp.key.hashCode() == hashKey) {
                return temp.collisionSolution.get(key);
            }
            if (temp.key.hashCode() < hashKey) {
                if (temp.leftChild == null) {
                    return null;
                } else {
                    temp = temp.leftChild;
                }
            } else {
                if (temp.rightChild == null) {
                    return null;
                } else {
                    temp = temp.rightChild;
                }
            }
        } while (true);

    }

    @Override
    public void put(KEY key, VALUE value) {
        int hashKey = key.hashCode();
        if (root == null) {
            root = new TreeNode<>(key, value);
            return;
        } else {
            temp = root;
        }
        do {
            if (temp.key.hashCode() == hashKey) {
                temp.collisionSolution.put(key, value);
                return;
            }
            if (temp.key.hashCode() < hashKey) {
                if (temp.leftChild == null) {
                    temp.leftChild = new TreeNode<>(key, value);
                    return;
                } else {
                    temp = temp.leftChild;
                }
            } else {
                if (temp.rightChild == null) {
                    temp.rightChild = new TreeNode<>(key, value);
                    return;
                } else {
                    temp = temp.rightChild;
                }
            }
        } while (true);
    }


    @Override
    public List<VALUE> filter(ValueFilter<VALUE> valueValueFilter) {
        List<VALUE> filtredList = new LinkedList<>();
        Iterator<VALUE> filtIterator = iterator();
        do {
            VALUE temp = filtIterator.next();
            if (valueValueFilter.filter(temp)) {
                filtredList.add(temp);
            }
        } while (!filtIterator.hasNext());
        return filtredList;
    }

    @Override
    public Iterator<VALUE> iterator() {
        return new TreeIterator();
    }

    public class TreeIterator implements Iterator<VALUE> {

        Stack<VALUE> valuesToIterate = new Stack<>();


        public TreeIterator() {
            treeWalk(root);
        }

        private void treeWalk(TreeNode<KEY, VALUE> temp) {

            LinkedList<TreeNode<KEY, VALUE>> tempList = new LinkedList<>();

            tempList.add(temp);
            do {
                temp = tempList.getLast();
                for (Map.Entry<KEY, VALUE> entry : temp.collisionSolution.entrySet()) {
                    valuesToIterate.push(entry.getValue());
                }
                if (temp.leftChild != null) {
                    tempList.addFirst(temp.leftChild);
                }
                if (temp.rightChild != null) {
                    tempList.addFirst(temp.rightChild);
                }
                tempList.removeLast();
            } while (!tempList.isEmpty());

        }

        @Override
        public boolean hasNext() {
            return valuesToIterate.empty();
        }

        @Override
        public VALUE next() {

            return valuesToIterate.pop();
        }

    }


}
