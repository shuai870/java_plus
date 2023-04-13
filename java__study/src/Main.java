import other.B;

import java.io.*;

public class Main {
    public static void main(String[] args) {
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File f = new File("C:\\Users\\master\\Desktop\\a.txt");

        try(FileWriter fw = new FileWriter(f);
            PrintWriter PW = new PrintWriter(fw);
        ){
            PW.println("asss");
            PW.println("cwdd");
            PW.println("wsss");


        }catch(IOException e){
            e.printStackTrace();
        }




        //        try(FileReader fr = new FileReader(f);
//            BufferedReader br = new BufferedReader(fr);
//           ){
//            while(true){
//
//                String line = br.readLine();
//                if(null == line){
//                    break;
//                }
//                System.out.println(line);
//
//            }
//
//
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }

//        try(FileReader fr = new FileReader(f)){
//            char[] all = new char[(int) f.length()];
//            fr.read(all);
//            for (char a : all) {
//                System.out.print(a);
//            }
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }







//        FileInputStream fis = null;
//       try {
//            fis =  new FileInputStream(f);//把文件读取到java虚拟机中 也即是读取内存里
//           byte[] all = new byte[(int)f.length()];
//           fis.read(all);
//           for(byte b:all){
//               System.out.println(b);
//           }
//
//       }catch(IOException e){
//           e.printStackTrace();
//       }finally {
//           if (null != fis){
//               try{
//                   fis.close();
//               }catch (IOException e){
//                   e.printStackTrace();
//               }
//           }
//       }





//        try ( FileOutputStream fos = new FileOutputStream(f);){
//            byte[] data = {88,89};
//            fos.write(data);
//        }catch(IOException e){
//            e.printStackTrace();
//        }
    }
}