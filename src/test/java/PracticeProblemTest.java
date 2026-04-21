import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.lang.reflect.Method;
import java.util.HashMap;

class PracticeProblemTest {

   // --- combineParallelArrays() Tests ---

   @Test
   @DisplayName("combineParallelArrays should correctly map names to ages in a HashMap")
   void combineParallelArraysTest1() {
      Class<?> testClass = PracticeProblem.class;
      try {
         String[] names = {"Alice", "Bob", "Charlie"};
         int[] ages = {25, 30, 35};
         Class<?>[] cArg = { String[].class, int[].class };
         Method method = testClass.getDeclaredMethod("combineParallelArrays", cArg);
         HashMap<String, Integer> result = (HashMap<String, Integer>) method.invoke(null, names, ages);
         
         assertEquals(3, result.size());
         assertEquals(25, result.get("Alice"));
         assertEquals(30, result.get("Bob"));
         assertEquals(35, result.get("Charlie"));
      } catch (NoSuchMethodException e) {
         fail("Method combineParallelArrays does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }

   @Test
   @DisplayName("combineParallelArrays should return an empty map for empty arrays")
   void combineParallelArraysTest2() {
      Class<?> testClass = PracticeProblem.class;
      try {
         String[] names = {};
         int[] ages = {};
         Class<?>[] cArg = { String[].class, int[].class };
         Method method = testClass.getDeclaredMethod("combineParallelArrays", cArg);
         HashMap<String, Integer> result = (HashMap<String, Integer>) method.invoke(null, names, ages);
         
         assertNotNull(result);
         assertTrue(result.isEmpty());
      } catch (NoSuchMethodException e) {
         fail("Method combineParallelArrays does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }

   // --- increaseAge() Tests ---

   @Test
   @DisplayName("increaseAge should increment the age of the specified person by 1")
   void increaseAgeTest1() {
      Class<?> testClass = PracticeProblem.class;
      try {
         HashMap<String, Integer> map = new HashMap<>();
         map.put("Alice", 25);
         map.put("Bob", 30);
         Class<?>[] cArg = { HashMap.class, String.class };
         Method method = testClass.getDeclaredMethod("increaseAge", cArg);
         method.invoke(null, map, "Alice");
         
         assertEquals(26, map.get("Alice"));
         assertEquals(30, map.get("Bob")); // Ensure others didn't change
      } catch (NoSuchMethodException e) {
         fail("Method increaseAge does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }

   @Test
   @DisplayName("increaseAge should handle age increments for different values")
   void increaseAgeTest2() {
      Class<?> testClass = PracticeProblem.class;
      try {
         HashMap<String, Integer> map = new HashMap<>();
         map.put("OldMan", 99);
         Class<?>[] cArg = { HashMap.class, String.class };
         Method method = testClass.getDeclaredMethod("increaseAge", cArg);
         method.invoke(null, map, "OldMan");
         
         assertEquals(100, map.get("OldMan"));
      } catch (NoSuchMethodException e) {
         fail("Method combineParallelArrays does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }

   // --- replaceName() Tests ---

   @Test
   @DisplayName("replaceName should replace the old key with the new key while keeping the same value")
   void replaceNameTest1() {
      Class<?> testClass = PracticeProblem.class;
      try {
         HashMap<String, Integer> map = new HashMap<>();
         map.put("Jon", 22);
         map.put("Sara", 28);
         
         Class<?>[] cArg = { HashMap.class, String.class, String.class };
         Method method = testClass.getDeclaredMethod("replaceName", cArg);
         method.invoke(null, map, "Jon", "Jonathan");
         
         assertFalse(map.containsKey("Jon"), "Old key should be removed");
         assertTrue(map.containsKey("Jonathan"), "New key should exist");
         assertEquals(22, map.get("Jonathan"), "Value should remain unchanged");
         assertEquals(28, map.get("Sara"), "Other entries should be untouched");
      } catch (NoSuchMethodException e) {
         fail("Method replaceName does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }

   @Test
   @DisplayName("replaceName should handle a scenario where name and replacement are identical")
   void replaceNameTest2() {
      Class<?> testClass = PracticeProblem.class;
      try {
         HashMap<String, Integer> map = new HashMap<>();
         map.put("Alice", 25);
         Class<?>[] cArg = { HashMap.class, String.class, String.class };
         Method method = testClass.getDeclaredMethod("replaceName", cArg);
         method.invoke(null, map, "Alice", "Alice");
         
         assertTrue(map.containsKey("Alice"));
         assertEquals(25, map.get("Alice"));
         assertEquals(1, map.size());
      } catch (NoSuchMethodException e) {
         fail("Method combineParallelArrays does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }

   @Test
   @DisplayName("replaceName should work even if the value is zero or negative")
   void replaceNameTest3() {
      Class<?> testClass = PracticeProblem.class;
      try {
         HashMap<String, Integer> map = new HashMap<>();
         map.put("Ghost", 0);
         Class<?>[] cArg = { HashMap.class, String.class, String.class };
         Method method = testClass.getDeclaredMethod("replaceName", cArg);
         method.invoke(null, map, "Ghost", "Spirit");
         
         assertEquals(0, map.get("Spirit"));
         assertFalse(map.containsKey("Ghost"));
      } catch (NoSuchMethodException e) {
         fail("Method combineParallelArrays does not exist");
      } catch (Exception e) {
         fail("Something weird happened: " + e);
      }
   }
}