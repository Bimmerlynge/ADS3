import java.util.HashMap;
import java.util.Map;

public class UtopiaCoins
{
  static Map<Integer, Integer> map;

  public static void main(String[] args)
  {
    map = new HashMap<>();
    map.put(0,0);
    map.put(1, 1);
    map.put(7, 1);
    map.put(10, 1);
    map.put(22, 1);
    //map.put(47,1);

    int amount = 57; //Indsæt her
    System.out.println(recur(amount));

  }

  private static int recur(int amount)
  {
    if (map.containsKey(amount))
      return map.get(amount);
    int min = Integer.MAX_VALUE;

    for (int i = 1; i < amount; i++)
    {
      int val = recur(amount - i);
      int val2 = recur(i);

      if (min > val2 + val)
      {
        min = val2 + val;

      }

    }
    map.put(amount, min);
    return min;

  }

  private static int greedy(int amount, int current)
  {
    if (amount == 0)
      return current;
    if (amount >= 22)
      amount -= 22;
    else if (amount >= 10)
      amount -= 10;
    else if (amount >= 7)
      amount -= 7;
    else
      amount -= 1;
    current++;
    return greedy(amount, current);
  }

}
