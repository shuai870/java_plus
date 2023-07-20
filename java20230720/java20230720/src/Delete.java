public class Delete {
    int [] arr = {1,2,3,4,5,6,7,8,9};
    //删除第三个
    void D(int refer){
        int [] brr = new int[arr.length-1];
        for(int i= 0;i<arr.length;i++){
            if(i==refer){
                continue;
            }else{
                //这里发现用continue的方法进行数组的删除工作是弄巧成拙
                //实际应该使用在小于refer采用一种方法  大于其他
            }
        }
    }
}
