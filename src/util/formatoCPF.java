
package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class formatoCPF extends PlainDocument {

    @Override
    public void insertString(int i, String str, AttributeSet a) throws BadLocationException {
        super.insertString(i, str.replaceAll("[^0-9-.-^]", ""), a); 
    }          
    
}

