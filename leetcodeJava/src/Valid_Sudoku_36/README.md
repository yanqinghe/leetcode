# Valid Sudoku
今天刷到LeetCode的第36题，题目详情如下。
## 题目描述
> Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

>A partially filled sudoku which is valid.
Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

简单的介绍一下，这道题是为了验证一个给定的表格是否为可行的数独问题。
数独的基本规则：对于每一行、每一列和九宫格都要保证1-9这9个数字全部出现且只出现一次，也就是说没有重复元素。
## 解题方案
对于给定的二维表。首先想到的就是遍历。

``` java

for(int i = 0;i<board.length;i++){
    boolean[] num = new boolean[9];
    for(int j = 0;j<board[0].length;j++){
        if(board[i][j]!='.'){
            int numTemp = board[i][j]-'1'；
			if(numRow[numTemp]) 
			return false;
			numRow[numTemp] = true;
			if(numRow[numTemp]) 
				return false;
			numRow[numTemp] = true；
		}
	}
}
```

写到这里突然意识到一个问题，那就是对于需要同时判断的行列还有九宫格内的数字是否重复，只使用一个临时数组的话不太够。如何尽可能的减少临时数组呢？从表中可以找出相应的规律
进行遍历操作，对于行和列的两种情况孩子主要将i和j进行调换即可。

即 **board[i][j]** 表示第 *i* 行和 *j* 列，**board[j][i]** 表示第 *j* 行和 *i* 列

那么对于九宫格内的如何进行转化呢。在遍历第一行的过程中（在这里只取能够对九宫格定位的第一个元素）
将前三行的情况整理在下面的表格中
| 遍历i,j | 转化后 | 遍历i,j | 转化后 | 遍历i,j | 转化后 |
| ------- | :----: | ------: | -----: | ------: | -----: |
| 0,0     | *0,0*  | 1,0     | *0,3*  | 2,0     | *0,6*  |
| 0,3     | *1,0*  | 1,3     | *1,3*  | 2,3     | *1,6*  |
| 0,7     | *2,0*  | 1,6     | *2,3*  | 2,6     | *2,6*  |


从中可以发现规律

**转化后的行号=i/3\*3+j/3**

**转化后的列号=i%3\*3+j%3**

具体实现的代码如下
------------------

``` java

public boolean isValidSudoku(char[][] board) {
    for(int i = 0;i<board.length;i++){
        boolean[] numRow = new boolean[9];
        boolean[] numRange = new boolean[9];
        boolean[] numSub = new boolean[9];
        for(int j = 0;j<board[0].length;j++){
            if(board[i][j]!='.'){
                int numTemp = board[i][j]-'1';
                if(numRow[numTemp]) 
                    return false;
                numRow[numTemp] = true;
            }
            if(board[j][i]!='.'){
                int numTemp = board[j][i]-'1';
                if(numRange[numTemp])
                    return false;
                numRange[numTemp] = true;
            }
            if(board[i/3*3+j/3][i%3*3+j%3]!='.'){
                int numTemp =board[i/3*3+j/3][i%3*3+j%3]-'1';
                if(numSub[numTemp])
                    return false;
                numSub[numTemp] = true;
            }
        }
    }
    return true;
}

```
