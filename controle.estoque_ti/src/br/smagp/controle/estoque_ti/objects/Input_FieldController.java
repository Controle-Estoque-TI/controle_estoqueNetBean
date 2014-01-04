package br.smagp.controle.estoque_ti.objects;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author AllexOnRails
 */
public class Input_FieldController extends PlainDocument {
   private int quantidadeMax;
   private String regex = "[0-9]+";
   
   
   public Input_FieldController(int maxLenght){
       super();
       if(maxLenght <=0){
           throw new IllegalArgumentException("Especifique a quantidade de caracteres permitidos.");
       }
       this.quantidadeMax = maxLenght;
   }
    
   @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException {
        if(str==null || getLength() == this.quantidadeMax)
            return;
        int totalQuantia = (getLength()+str.length());
        
        if(str.matches(regex)){
            JOptionPane.showMessageDialog(null, "Caracteres permitidos - apenas letras.", "Caracter inválido encontrado", JOptionPane.WARNING_MESSAGE);
        }
        
        if(totalQuantia <= this.quantidadeMax){
            super.insertString(offset, str.toUpperCase().replaceAll("[^a-z|A-Z|^ ]", ""), attr);
            return;
        }
        
        String novaString = str.substring(0, getLength() - this.quantidadeMax);
        super.insertString(offset, novaString, attr);
    }

    public void replace(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException {
        super.insertString(offset, str.toUpperCase().replaceAll("[^a-z|A-Z|^ ]", ""), attr);
    }
}
