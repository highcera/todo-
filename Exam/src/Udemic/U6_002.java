package Udemic;

public class U6_002 {
    public static void main(String[] args) {}
}
 
// modifier protected not allowed here:
// interface Diver { protected abstract void dive(); }
 
// missing method body:
// abstract class ScubaDiver { protected void dive(); }
 
// illegal combination of modifiers: abstract and final:
// abstract class ScubaDiver { protected final abstract void dive(); }
 
// abstract methods cannot have a body
// abstract class ScubaDiver { protected abstract void dive() {} }
 
abstract class ScubaDiver { protected abstract void dive(); }

// 맨 앞 public 불필요. abstract - final X, body {} X
// interface 모든 요소는 pubplic -> protected X
// (public) abstract ScubaDiver { protected abstract void dive(); }