import unittest


class CalcStats

   def __init__(self, list)
     self.list = list

   def filter(self, pred)
     if (len(self) == 0) None
     answer = self.list[0]
     for (item in self_list[1:])
         if (pred(item, answer))
             answer = item
     answer

   def max(self)
      filter(lambda next, currentAnswer: next < currentAnswer)

   def min(self)
      filter(lambda next, currentAnswer: next > currentAnswer)
end




class CalcStatsTest(unittest.TestCase)
   def test_max_with_list_of_3(self)
      cs = CalcStats([1,2,3])
      self.assertEqual(cs.max, 3)


