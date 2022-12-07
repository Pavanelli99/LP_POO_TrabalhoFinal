import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreeRepository {

    //DAO = Data access Object > Antigamente 
    //DAO > CRUD >
    // c -> create (insert into)
    // R -> read  (select from)
    // U -> update (update set)
    // D -> delete (delete from)

    private Connection conn =  null; //atributo de conexão

    public TreeRepository(){
       this.conn = ConnectionFactory.createConnection();
    }

    public void save(Node _node){

        String aSQL = "INSERT INTO tb_node(info, esq, dir, valor) VALUES (?, ?, ?, ?)"; //template da string
        try {

            PreparedStatement ps = conn.prepareStatement(aSQL);
            ps.setInt(1, _node.getInfo());
            ps.setInt(4, _node.getValor());

            ps.executeUpdate(); //INSERT , UPDATE E DELETE

            System.out.println("INFO: Arvore cadastrada!");

        } catch (SQLException e) {

            // TODO Auto-generated catch block
            System.out.println("Error: Não foi possivel inserir a arvore!");
            e.printStackTrace();

        }
    }

    public Tree getOne(int id) {  

        String sql = "SELECT * FROM tb_Tree WHERE info =? ";
        Tree t = new Tree();

        try {

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){ 
                   t.setInfo(rs.getInt("Info"));
                   t.setValor(rs.getInt("Valor"));
              }

              //System.out.println(rs);

              
              return t;
        } catch (SQLException e) {

            // TODO Auto-generated catch block
            System.out.println("Erro ao buscar usuário com id =" + id);
            e.printStackTrace();
        }

        return null;
        
    }

    public List<Tree> selectAll(){

        String sql = "SELECT * FROM tb_Tree";

        List<Tree> trees = new ArrayList<Tree>();

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);

           // ps.executeQuery(); //somente em selectAll
           
           ResultSet rs = ps.executeQuery();

           while(rs.next()){ // toda consulta 
             // System.out.println(
                // rs.getInt("id") +" - " +
                // rs.getString("Treename") +" - " +
                // rs.getString("password")
                // );
                Tree t = new Tree();
                t.setId(rs.getInt("id"));
                t.setTreename(rs.getString("Treename"));
                t.setPassword(rs.getString("password"));
                t.setStatus(rs.getInt("status"));
                t.setToken(rs.getDouble("token"));
                trees.add(t);
           }

           System.out.println(rs);
           
        } catch (SQLException e) {
            System.out.println("Error: Não foi possivel buscar os usuários");
            e.printStackTrace();
        }
       
        return null;

    }



    public List<Tree> selectAllActive () {
        
        String sql = "SELECT * FROM tb_Tree WHERE status = 1";

        List<Tree> activeTrees = new ArrayList<Tree>();

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);

           // ps.executeQuery(); //somente em selectAll
           
           ResultSet rs = ps.executeQuery();

           while(rs.next()){ // toda consulta 
                Tree u = new Tree();
                u.setId(rs.getInt("id"));
                u.setTreename(rs.getString("Treename"));
                u.setPassword(rs.getString("password"));
                u.setStatus(rs.getInt("status"));
                u.setToken(rs.getDouble("token"));
                activeTrees.add(u);
           }

           System.out.println(rs);
           
        } catch (SQLException e) {
            System.out.println("Erro: Não foi possivel buscar os usuários ativos");
            e.printStackTrace();
        }
       
        return activeTrees;
    }
     
}
