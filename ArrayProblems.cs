
using System;

namespace DataStructures
{
    // Array Prob lems
    public class ArrayProblems
    {
        // Problem 1.7 - Implement an algorthm such that if an element in MxN matrix is 0, set the entire row and column is zero.
        public int[][] SetZeros(int[][] matrix)
        {

            bool[] rows = new bool[matrix.Length];
            bool[] cols = new bool[matrix[0].Length];

            for (int i = 0; i < rows.Length; i++)
            {
                for (int j = 0; j < cols.Length; j++)
                {
                    if (matrix[i][j] == 0)
                    {
                        rows[i] = true;
                        cols[j] = true;
                    }
                }
            }

            for (int i = 0; i < rows.Length; i++)
            {
                for (int j = 0; j < cols.Length; j++)
                {

                    if ((rows[i]) || (cols[j]))
                        matrix[i][j] = 0;
                }
            }

            return matrix;
        }

        // Problem 1.6 - rotate NxN matrix
        public void RotateMatrix(int[][] mat, int n)
        {
            int layer = 0, first = 0, last = 0, temp = 0, i = 0;

            for (layer = 0; layer < n / 2; layer++)
            {
                first = layer;
                last = n - 1 - first;

                for (i = first; i < last; i++)
                {
                    temp = mat[first][i];
                    mat[first][i] = mat[last - i][first];
                    mat[last - i][first] = mat[last][last - i];
                    mat[last][last - i] = mat[i][last];
                    mat[i][last] = temp;
                }
            }
        }

        // Remove Duplicates in place without using any additinal memory
        public int[] RemoveDuplicates(int[] arr)
        {

            int i = 1;
            if (arr.Length == 0 || arr.Length == 1)
                return arr;


            for (int j = 1; j < arr.Length; j++)
            {
                if (arr[j] != arr[j - 1])
                {
                    arr[i] = arr[j];
                    i++;
                }
          
            }
            if (i < arr.Length)
                arr[i] = '\0';


            return arr;
        }

        public int[] twoSum(int[] nums, int target)
        {
            int i = 0, j = nums.Length - 1;
            while (i < j)
            {
                int sum = nums[i] + nums[j];
                if (sum > target) j--;
                if (sum < target) i++;
                else
                    return new int[] { i, j };
                
            }
            throw new Exception("no sum solution found");
        }

   }
}
