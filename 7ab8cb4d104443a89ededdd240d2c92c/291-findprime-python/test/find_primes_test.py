import unittest
import sys
from src import find_primes


class TestFindPrimes(unittest.TestCase):
    def setUp(self):
        self.stream_out = MyStream()
        self.stream_in = MyStream()
        self.out_stream = sys.stdout
        self.in_stream = sys.stdin
        sys.stdout = self.stream_out
        sys.stdin = self.stream_in
        pass

    def test_find_primes1(self):
        ans = ['2 2', '3 5', '3 17']
        self.stream_in.write('3')
        self.stream_in.write('4')
        self.stream_in.write('8')
        self.stream_in.write('20')
        find_primes.find_primes()
        for i in range(0, 2):
            result = self.stream_out.buff[i*2]
            self.assertEqual(result, ans[i])

    def test_find_primes_2(self):
        ans = ['3 5', '3 7', '5 7']
        self.stream_in.write('3')
        self.stream_in.write('8')
        self.stream_in.write('10')
        self.stream_in.write('12')
        find_primes.find_primes()
        for i in range(0, 2):
            result = self.stream_out.buff[i*2]
            self.assertEqual(result, ans[i])

    def test_find_primes3(self):
        ans = ['3 11', '3 13', '5 13']
        self.stream_in.write('3')
        self.stream_in.write('14')
        self.stream_in.write('16')
        self.stream_in.write('18')
        find_primes.find_primes()
        for i in range(0, 2):
            result = self.stream_out.buff[i*2]
            self.assertEqual(result, ans[i])

    def test_find_primes4(self):
        ans = ['3 17', '3 19', '3 23']
        self.stream_in.write('3')
        self.stream_in.write('20')
        self.stream_in.write('22')
        self.stream_in.write('26')
        find_primes.find_primes()
        for i in range(0, 2):
            result = self.stream_out.buff[i*2]
            self.assertEqual(result, ans[i])

    def test_find_primes5(self):
        ans = ['3 3', '5 23', '7 23']
        self.stream_in.write('3')
        self.stream_in.write('6')
        self.stream_in.write('28')
        self.stream_in.write('30')
        find_primes.find_primes()
        for i in range(0, 2):
            result = self.stream_out.buff[i*2]
            self.assertEqual(result, ans[i])

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
