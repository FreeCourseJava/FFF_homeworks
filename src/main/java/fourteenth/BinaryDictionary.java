package fourteenth;


import java.util.*;

public class BinaryDictionary<KEY, VALUE> implements Dictionary<KEY, VALUE>, Filterable<VALUE>, Iterable<VALUE> {

    private TreeNode<KEY, VALUE> root, temp;


    @Override
    public VALUE get(KEY key) {
        int hashKey;
        if (key == null) {
            hashKey = 0;
        } else {
            hashKey = key.hashCode();
        }
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
                temp = temp.leftChild;
            } else {
                temp = temp.rightChild;
            }
        } while (temp != null);
        return null;
    }

    @Override
    public void put(KEY key, VALUE value) {
        int hashKey;
        boolean continueFlag = true;
        if (key == null) {
            hashKey = 0;
        } else {
            hashKey = key.hashCode();
        }
        if (root == null) {
            root = new TreeNode<>(key, value);
            return;
        } else {
            temp = root;
        }
        do {
            if (temp.key.hashCode() == hashKey) {
                continueFlag = false;
            }
            if (temp.key.hashCode() < hashKey) {
                if (temp.leftChild == null) {
                    continueFlag = false;
                } else {
                    temp = temp.leftChild;
                }
            }
            if (temp.key.hashCode() > hashKey) {
                if (temp.rightChild == null) {
                    continueFlag = false;
                } else {
                    temp = temp.rightChild;
                }
            }
        } while (continueFlag);
        if (temp.key.hashCode() == hashKey) {
            temp.collisionSolution.put(key, value);
        }
        if (temp.key.hashCode() < hashKey) {
            temp.leftChild = new TreeNode<>(key, value);
        }
        if (temp.key.hashCode() > hashKey) {
            temp.rightChild = new TreeNode<>(key, value);
        }
    }


    @Override
    public List<VALUE> filter(ValueFilter<VALUE> valueValueFilter) {
        List<VALUE> filtredList = new LinkedList<>();

        for (VALUE temp : this) {
            if (valueValueFilter.filter(temp)) {
                filtredList.add(temp);
            }
        }

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
            return !valuesToIterate.empty();
        }

        @Override
        public VALUE next() {
            return valuesToIterate.pop();
        }

    }


}
