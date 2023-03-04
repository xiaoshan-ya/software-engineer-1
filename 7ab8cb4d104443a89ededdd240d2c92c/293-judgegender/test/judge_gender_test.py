import unittest
import sys
from src import judge_gender


class TestGender(unittest.TestCase):
    def setUp(self):
        self.stream_out = MyStream()
        self.stream_in = MyStream()
        self.out_stream = sys.stdout
        self.in_stream = sys.stdin
        sys.stdout = self.stream_out
        sys.stdin = self.stream_in
        pass

    def test_gender1(self):
        self.stream_in.write('2')
        self.stream_in.write('wWangG')
        self.stream_in.write('Xiaooyi')
        result = judge_gender.judge_gender()
        self.assertEqual(result, "CHAT WITH HER!\nIGNORE HIM!")

    def test_gender2(self):
        list = ['XiaoMei', 'KeDi']
        self.stream_in.write(str(len(list)))
        for i in range(len(list)):
            self.stream_in.write(list[i])
        result = judge_gender.judge_gender()
        self.assertEqual(result, "CHAT WITH HER!\nCHAT WITH HER!")

    def test_gender3(self):
        list = ['SoftwareEngineer', 'NanjingUniversity']
        self.stream_in.write(str(len(list)))
        for i in range(len(list)):
            self.stream_in.write(list[i])
        result = judge_gender.judge_gender()
        self.assertEqual(result, "CHAT WITH HER!\nIGNORE HIM!")

    def tearDown(self):
        sys.stdout = self.out_stream
        sys.stdin = self.in_stream
        pass


class MyStream:
    def __init__(self):
        self.buff = []
        self.write_count = 0

    def write(self, output_stream):
        self.buff.append(output_stream)
        if len(self.buff) > 10000:
            sys.exit("Too many outputs, error! There may be an endless loop in your code!")

    def readline(self):
        if len(self.buff) > 0:
            cur = self.buff[0]
            del self.buff[0]
            return cur
