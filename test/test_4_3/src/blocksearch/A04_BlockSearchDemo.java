package blocksearch;

//拓展的分组查找(数据更加无规律)
public class A04_BlockSearchDemo {
    public static void main(String[] args) {
        int[] arr = {27,22,30,40,36,
                    16,19,16,20,
                    7,10,
                    43,50,48};
        int num=7;
        Block b1=new Block(22,40,0,4);
        Block b2=new Block(13,20,5,8);
        Block b3=new Block(7,10,9,10);
        Block b4=new Block(43,50,11,13);
        //定义数组来管理三个块的对象
        Block[] blocks={b1,b2,b3,b4};
        System.out.println(getIndex(blocks, arr, num));
    }

    private static int getIndex(Block[] blocks, int[] arr, int num) {
        //找到对应的块
        int blockIndex = getBlockIndex(blocks, num);
        if(blockIndex==-1){
            System.out.println("数据不存在");
            return -1;
        }
        //得到对应块的起始和结束索引
        int startIndex = blocks[blockIndex].getStartIndex();
        int endIndex = blocks[blockIndex].getEndIndex();
        //开始遍历得到结果
        for (int i = startIndex; i <= endIndex; i++) {
            if(arr[i]==num){
                return i;
            }
        }
        return -1;
    }

    //找到数据属于哪个块
    private static int getBlockIndex(Block[] blocks, int num){
        for (int i = 0; i < blocks.length; i++) {
            if(num>=blocks[i].getMin()&&num<=blocks[i].getMax()){
                return i;
            }
        }
        return -1;
    }
}

class Block{
    private int min;
    private int max;
    private int startIndex;
    private int endIndex;

    public Block() {
    }

    public Block(int min, int max, int startIndex, int endIndex) {
        this.min = min;
        this.max = max;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    /**
     * 获取
     * @return min
     */
    public int getMin() {
        return min;
    }

    /**
     * 设置
     * @param min
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * 获取
     * @return max
     */
    public int getMax() {
        return max;
    }

    /**
     * 设置
     * @param max
     */
    public void setMax(int max) {
        this.max = max;
    }

    /**
     * 获取
     * @return startIndex
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * 设置
     * @param startIndex
     */
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * 获取
     * @return endIndex
     */
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * 设置
     * @param endIndex
     */
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public String toString() {
        return "Block{min = " + min + ", max = " + max + ", startIndex = " + startIndex + ", endIndex = " + endIndex + "}";
    }
}
