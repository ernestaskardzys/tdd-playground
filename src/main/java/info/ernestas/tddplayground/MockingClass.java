package info.ernestas.tddplayground;

/**
 *
 * @author Ernestas.Kardzys
 */
public class MockingClass {

    private OtherClass otherClass;
    
    public MockingClass() {
        
    }
    
    public MockingClass(OtherClass otherClass) {
        this.otherClass = otherClass;
    }
    
    public boolean testIfTrue() {
        return true;
    }
    
    public String getResultFromOtherClass() {
        return otherClass.getResult();
    }
    
}
