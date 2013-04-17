import java.util.*;

public class JavaIterableExample {
  public static List getUserNames(List people) {
    List outputList = new ArrayList(people.size());
    Iterator iter = people.iterator();
    while(iter.hasNext()) {
      Person person = (Person) iter.next();
      outputList.add(person.name());
    }
    return outputList;
  }

  public static List<String> getUserNames5(List<Person> people) {
    List<String> outputList = new ArrayList<String>(people.size());
    for(Person person: people) {
      outputList.add(person.name());
    }
    return outputList;
  }
}
