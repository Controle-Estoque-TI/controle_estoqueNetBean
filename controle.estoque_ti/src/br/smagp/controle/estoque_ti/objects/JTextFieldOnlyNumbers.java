/**
 * ESTA É A CLASSE OBJETO RESPONSAVEL POR ALTERAR UM DETERMINADO
 * JTEXT-FIELD PARA INSERIR APENAS NUMEROS.
 **/

package br.smagp.controle.estoque_ti.objects;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * @author AllexOnRails
 */
public final class JTextFieldOnlyNumbers extends JTextField{
    private int maximoCaracteres=-1; // definição de -1 como valor normal de um textfield sem limite de caracters -> Leia mais em: Como alterar o componente JTextField para aceitar apenas números http://www.devmedia.com.br/como-alterar-o-componente-jtextfield-para-aceitar-apenas-numeros/26152#ixzz2pKeJLdoE
    
    public JTextFieldOnlyNumbers(){
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt){
                jTextFieldKeyTyped(evt);
            }
        });
    }
    
    public JTextFieldOnlyNumbers(int max){
        super();
        setMaximoCaracteres(max);// define o tamanho máximo que deve ser aceito no jtextfield que foi recebido no construtor 
        addKeyListener(new java.awt.event.KeyAdapter() { 
            @Override 
            public void keyTyped(java.awt.event.KeyEvent evt) { 
                jTextFieldKeyTyped(evt);
            }
        }); 
    }
    
    private void jTextFieldKeyTyped(KeyEvent evt) { 
        String caracteres="0987654321"; //lista de caracters que não devem ser aceitos
        if(!caracteres.contains(evt.getKeyChar()+"")){
            // se o caracter que gerou o evento estiver não estiver na lista 
            evt.consume();//aciona esse propriedade para eliminar a ação do evento
            JOptionPane.showMessageDialog(null, "Caracteres permitidos - apenas numeros.", "Caracter inválido", JOptionPane.WARNING_MESSAGE);
        }
        
        /** A condicional IF abaixo é para verificar o tamanho da string do campo informado sendo 
         * esta maior ou igual ao tamanho máximo descrito na criação do JTextField logo este 
         * cancelará a incerção de valores nao permitindo inserir mais. 
         **/ 
        
        if((getText().length()>=getMaximoCaracteres())&&(getMaximoCaracteres()!=-1)){ 
            evt.consume(); 
            setText(getText().substring(0,getMaximoCaracteres()));
            // esta linha acima é para remover os caracters inválidos caso o 
            //usuário tenha copiado o conteúdo de algum lugar, ou seja, com tamanho maior que o definido 
        }
        
        if((getText().length()>=getMaximoCaracteres())){
            JOptionPane.showMessageDialog(null, "Limite de "+this.getMaximoCaracteres()+" caracteres excedido", "ERRO 386 - Limite excedido", JOptionPane.ERROR_MESSAGE);
        }
     }
    
    public int getMaximoCaracteres(){ 
        return maximoCaracteres; 
    } 
    
    public void setMaximoCaracteres(int maximoCaracteres) { 
        this.maximoCaracteres = maximoCaracteres;
    }
}