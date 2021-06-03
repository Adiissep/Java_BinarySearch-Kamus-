package binary.search.string;
import java.lang.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Adi Sepriyadi 
 * TI20E REG B 
 * Universitas Nusa Putra
 * 
 */
public class BinarySearch {
    private String kata;
    private String ENG[]=new String[100];
    private String IND[]=new String[100];
    private int counter;

        public BinarySearch() {
            kata=null;
            counter=0;
        }
        
        public BinarySearch(String k) {
            kata=k;
        }
        
        public void ReadFile (){
            FileReader fReader=null;
            StreamTokenizer InputST=null;
            int i=0;
            String output = null;
                             
    try {
        fReader = new FileReader ("C:\\Users\\ADVANG4C\\Documents\\NetBeansProjects\\Java_BinarySearchString\\src\\binary\\search\\string\\BinarySearchDictionary.txt");
        
        InputST = new StreamTokenizer (fReader);
        InputST.nextToken();
        
        while (InputST.ttype!= StreamTokenizer.TT_EOF){
            if (InputST.ttype == StreamTokenizer.TT_WORD)
                ENG[i] = InputST.sval;
            else
                System.out.println("File Format Rusak atau Tidak ada!");
            if (InputST.nextToken()==StreamTokenizer.TT_WORD)
            IND[i] = InputST.sval;
            else
                System.out.println("");
            InputST.nextToken();
            i++;
            counter=counter+1;
        }
    }
    
    catch (FileNotFoundException ex){
        System.out.println("File tidak ada : BinarySearchDictionary.txt");
    }
    catch (IOException ex){
         System.out.println(ex.getMessage());
    }
    finally{
        try{
            if(fReader!=null) fReader.close();
        }
        catch (IOException ex){
            System.out.println(ex);
        }
    }
 }
        
public String Cari (int a) {
    int i;
    String output=kata+ " Tidak Ada Dalam Kamus ";
    for (i=0;i<counter;i++){
    if (a==0){
        if (kata.equalsIgnoreCase(ENG[i])==true)
            output=IND[i];
    }else if (a==1){
        if (kata.equalsIgnoreCase(IND[i])==true)
            output=ENG[i];
    }    
    }
    return output;
}
    
public static void main(String[] args) {
    Scanner cari = new Scanner (System.in);
    String input,a,b;
    int pilih;
    do{
      System.out.println("\n\n==========KAMUS==========");
      System.out.println("1. English-Indonesian ");
      System.out.println("2. Indonesian-English ");
      System.out.println("0. Keluar");
      System.out.println("=========================");
      System.out.print("Pilihan Menu : ");pilih = cari.nextInt();
      
      switch(pilih){
          case 1:
          System.out.print("Masukan Kata Dalam Bahasa Inggris = \n\n");
          Scanner scan1=new Scanner(System.in);
          input=scan1.nextLine();
          
          BinarySearch Kamus1 = new BinarySearch(input); 
          Kamus1.ReadFile();
          a=Kamus1.Cari(0);
          if (a.equals(input+" Tidak Ada Dalam Kamus"))
              System.out.println(""+Kamus1.Cari(0));
          else
              System.out.println(Kamus1.Cari(0));
          break;
          
          case 2:
          System.out.println("Masukan Kata Dalam Bahasa Indonesia = \n");
          Scanner scan2=new Scanner(System.in);
          input=scan2.nextLine();
          
          BinarySearch Kamus2 = new BinarySearch(input);
          Kamus2.ReadFile();
          a=Kamus2.Cari(1);
          if (a.equals(input+" Tidak Ada Dalam Kamus"))
              System.out.println(""+Kamus2.Cari(1));
          else
              System.out.println(Kamus2.Cari(1));
          break;   
      }
    }while(pilih!=0);
   }
}
