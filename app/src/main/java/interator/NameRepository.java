package interator;

public class NameRepository implements collection{

    public String names[] = {"Robert" , "John" ,"Julie" , "Lora", "Johnny"};

    @Override
    public Iterator_test getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator_test {
        int index;

        @Override
        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
