

public class atividade {
    

    public static void main(String[] args) {
        Tree testTree = new Tree();
        
        testTree.inserir(10, testTree.root);
        testTree.inserir(11, testTree.root);
        testTree.inserir(16, testTree.root);
        testTree.inserir(15, testTree.root);          
        testTree.inserir(17, testTree.root);
      
       //testTree.remover(testTree.root, null, 16 );
  
        //if (!testTree.procurar(testTree.root, 22, false))
        //  System.out.println("Elemento não encontrado! \n");
        
        System.out.println(testTree);
    
    
      }
    
    
    }
  
