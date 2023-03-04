import unittest
from src import Exam


class TestExam(unittest.TestCase):
	def setUp(self):
		pass

	# is_divisible begin

	def test1(self):
		expect = True
		result = Exam.is_divisible(21, 7)
		self.assertEqual(expect, result)

	# is_divisible end
	# is_equal_list begin

	def test2(self):
		l1 = [1, 2, 3, 4]
		l2 = [1, 2, 3, 4]
		expect = True
		result = Exam.is_equal_list(l1, l2)
		self.assertEqual(expect, result)

	# is_equal_list end
	# matrix_flip begin

	def test3(self):
		expect = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 0, 1, 2], [3, 4, 5, 6]]
		result = Exam.matrix_process([[3, 4, 5, 6], [9, 0, 1, 2], [5, 6, 7, 8], [1, 2, 3, 4]], 1)
		self.assertTrue(expect == result)

	# matrix_flip end
	# remove_element begin

	def test4(self):
		expect = [1, 2, 4]
		result = Exam.remove_element([1, 2, 3, 4], 3)
		self.assertEqual(expect, result)

	# remove_element end
	# reverse_sentence_from_file begin

	def test5(self):
		expect = 'Dunk Slam'
		result = Exam.reverse_sentence_from_file('./test/Sentence1')
		self.assertEqual(expect, result)

	# reverse_sentence_from_file end

	def tearDown(self):
		pass
