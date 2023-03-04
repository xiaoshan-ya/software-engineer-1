import unittest
import sys

import password_validate


class TestValidator(unittest.TestCase):

    def test_validator_one(self):
        result = password_validate.password_validate("1234");
        self.assertEqual(1,result);

    def test_validator_two(self):
        result = password_validate.password_validate("abcdef");
        self.assertEqual(2,result);

    def test_validator_three(self):
        result = password_validate.password_validate("abc123xyz");
        self.assertEqual(3,result);

    def test_validator_four(self):
        result = password_validate.password_validate("1234h@xor");
        self.assertEqual(4,result);