#Taylor Palm
#
#Programming Assignment 5
#
# Don't rename any functions, although feel free to implement any helper functions
# you find useful.
#
# 1) Implement the naive_string_matcher function as specified in its docstring.
#    This is a variation of the algorithm on page 988 of the textbook.
#    Read the docstring below carefully so you know what I've changed.
#
# 2) Implement the p_naive_string_matcher function as specified in its docstring.
#
# 3) In the time_results function below, implement any code needed to compare the runtimes
#    of the sequential and parallel version on string of varying lengths and with varying number of matches.
#    You will need to figure out how to generate strings of varying lengths.  And with a varying number of matches.
#    This is not as hard as it might seem at first.  Recall that you can use the multiplication operator * with
#    a string and an integer as follows:  "abc" * 5 will evaluate to "abcabcabcabcabc"
#
# 4) Answer the following questions here in a comment based on #3:
#
#    Q1: After running time_results, fill in this table in this comment for whatever P and T lengths
#        you tried (make sure you vary lengths from short to longer:
#        T-length    P-Length    SequentialTime    ParallelTime
#      ----------  ----------  ----------------  --------------
#              10           1       6.099e-06      0.136598699
#              10           5       5.099e-06      0.139953400
#              10          10       3.999e-06      0.139605100
#             100           1       2.100e-05      0.241538000
#             100          50       1.289e-05      0.135883499
#             100         100       3.900e-06      0.139837600
#            1000           1       0.000143199    0.233847099
#            1000         500       0.0002756      0.239002000
#            1000        1000       4.300e-06      0.136713399
#           10000           1       0.001353099    0.239678500
#           10000        5000       0.004701499    0.135571099
#           10000       10000       4.099e-6       0.276448799
#          100000           1       0.0270500      0.281734499
#          100000       50000       0.241149399    0.281734499
#          100000      100000       4.299e-06      0.145425799
#         1000000           1       0.271768199    0.650465999
#         1000000      500000      32.23496014     12.16574095
#         1000000     1000000       4.500e-06      0.139798700
#
#    Q2: How do the times (of both versions) vary by string length?  If T is held constant, and pattern P length varied, how does
#        that affect runtime?  If P length is held constant, and text T length varied, how does that affect runtimes?
#
#       Overall runtimes tend to get worse with increasing string length for both sequential and parallel.
#
#       For sequential with T held constant: 
#       for T<1000, runtimes in decreasing order were P=1, P=T/2, P=T
#       for T>=1000, runtimes in decreasing order were P=T/2, P=1, P=T 
#
#       For parallel with T held constant:
#       The results are sort of inconsistent, there does not seem to be a significantly different runtime among the
#       variable Ps except for T=1000000 where the runtime for P=T/2 is much slower than for P=1 or P=T.
#
#       For sequential with P held constant, runtimes increase as T gets larger.
#       For parallel with P held constant, it is a little more variable, but again overall runtimes do increase as T gets larger.
#
#
#    Q3: At what lengths of P and/or T is the sequential version faster?
#
#        Sequential is faster than parallel for all but T=1000000 and P=500000
#
#    Q4: At what lengths of P and/or T is the parallel version faster?
#
#        Parallel is only faster than sequential for T=1000000 and P=500000
#
#    Q5: Are the results consistent with the speedup you computed in Problem Set 4?  If not, what do you think caused
#        the inconsistency with the theoretical speedup?
#   
#       In problem set 4, I found Work=O(m(n-m+1))-->O(n) since n>m, and parallelism as O(n)/P. With 4 cores, the parallel algorithm should have been
#       4x as fast as the sequential algorithm. However, sequential was faster for nearly every combination of T and P. The only time parallel was
#       faster was for T=1000000 and P=500000, and even then it was only 2.667x faster. Therefore, my results were very inconsistent with the
#       theoretical speedup. This is very likely due to the GIL (Global Interpreter Lock) that essentially "locks" the interpreter and stops
#       it from running multiple threads.

# These are imports you will likely need.  Feel free to add any other imports that are necessary.
from multiprocessing import Process, Pool
from functools import partial
from timeit import timeit
from tabulate import tabulate

def time_results() :
    """Write any code needed to compare the timing of the sequential and parallel versions
    with a variety of string lengths.  Have this print a table of the following form:

    T-length   P-Length   SequentialTime  ParallelTime
    """

    #Test 1: T=10, P=1,5,10 (P1, P2, PT)

    PT="p"  * 10

    P2="p"  * 5

    P1="p"



    #Test 2: T=100, P=1,50,100 (P1, P3, PT2)

    PT2="p"  * 100

    P3="p"  * 50



    #Test 3: T=1000, P=1,500,1000 (P1, P4, PT3)

    PT3="p"  * 1000

    P4="p"  * 500



    #Test 4: T=10000, P=1,5000,10000 (P1,P5, PT4)

    PT4="p" * 10000

    P5="p"  * 5000




    #Test 5: T=100000, P=1,50000,100000(P1,P6, PT5)

    PT5="p"  * 100000

    P6="p"  * 50000



    #Test 6: T=1000000, P=1,500000,1000000(P1,P7,PT6)

    PT6="p"  * 1000000

    P7="p"  * 500000

    table = [

            [len(PT), len(P1), (timeit(lambda:naive_string_matcher(PT, P1), number=1)), (timeit(lambda:p_naive_string_matcher(PT, P1), number=1))],

            [len(PT), len(P2), (timeit(lambda:naive_string_matcher(PT, P2), number=1)),  (timeit(lambda:p_naive_string_matcher(PT, P2), number=1))],

            [len(PT), len(PT), (timeit(lambda:naive_string_matcher(PT, PT), number=1)),  (timeit(lambda:p_naive_string_matcher(PT, PT), number=1))],

            
            [len(PT2), len(P1), (timeit(lambda:naive_string_matcher(PT2, P1), number=1)), (timeit(lambda:p_naive_string_matcher(PT2, P1), number=1))],

            [len(PT2), len(P3), (timeit(lambda:naive_string_matcher(PT2, P3), number=1)), (timeit(lambda:p_naive_string_matcher(PT2, P3), number=1))],

            [len(PT2), len(PT2), (timeit(lambda:naive_string_matcher(PT2, PT2), number=1)), (timeit(lambda:p_naive_string_matcher(PT2, PT2), number=1))],
            
            [len(PT3), len(P1), (timeit(lambda:naive_string_matcher(PT3, P1), number=1)), (timeit(lambda:p_naive_string_matcher(PT3, P1), number=1))],

            [len(PT3), len(P4), (timeit(lambda:naive_string_matcher(PT3, P4), number=1)), (timeit(lambda:p_naive_string_matcher(PT3, P4), number=1))],

            [len(PT3), len(PT3), (timeit(lambda:naive_string_matcher(PT3, PT3), number=1)), (timeit(lambda:p_naive_string_matcher(PT3, PT3), number=1))],

            [len(PT4), len(P1), (timeit(lambda:naive_string_matcher(PT4, P1), number=1)), (timeit(lambda:p_naive_string_matcher(PT4, P1), number=1))],

           [len(PT4), len(P5), (timeit(lambda:naive_string_matcher(PT4, P5), number=1)),  (timeit(lambda:p_naive_string_matcher(PT4, P5), number=1))],
            [len(PT4), len(PT4), (timeit(lambda:naive_string_matcher(PT4, PT4), number=1)), (timeit(lambda:p_naive_string_matcher(PT4, PT4), number=1))],



            [len(PT5), len(P1), (timeit(lambda:naive_string_matcher(PT5, P1), number=1)), (timeit(lambda:p_naive_string_matcher(PT5, P1), number=1))],

            [len(PT5), len(P6), (timeit(lambda:naive_string_matcher(PT5, P6), number=1)), (timeit(lambda:p_naive_string_matcher(PT5, P6), number=1))],

           [len(PT5), len(PT5), (timeit(lambda:naive_string_matcher(PT5, PT5), number=1)), (timeit(lambda:p_naive_string_matcher(PT5, PT5), number=1))],


            [len(PT6), len(P1), (timeit(lambda:naive_string_matcher(PT6, P1), number=1)), (timeit(lambda:p_naive_string_matcher(PT6, P1), number=1))],

            [len(PT6), len(P7), (timeit(lambda:naive_string_matcher(PT6, P7), number=1)), (timeit(lambda:p_naive_string_matcher(PT6, P7), number=1))],

           [len(PT6), len(PT6), (timeit(lambda:naive_string_matcher(PT6, PT6), number=1)), (timeit(lambda:p_naive_string_matcher(PT6, PT6), number=1))]
            ]



    print(tabulate(table, headers=["T-length", "P-Length", "SequentialTime", "ParallelTime"]))

def naive_string_matcher(T, P) :
    """Naive string matcher algorithm from textbook page 988.

    Slight variation of the naive string matcher algorithm from
    textbook page 988.  Specifically, the textbook version prints the
    results.  This python function does not print the results.
    Instead, it generates and returns a list of the indices at the start
    of each match.  For example, if T="abcabcabc" and P="def", this function
    will return the empty list [] since the pattern doesn't appear in T.
    For that same T, if the pattern P="abc", then this function will return
    the list [0, 3, 6] since the pattern appears 3 times, beginning on indices
    0, 3, and 6.

    Keyword arguments:
    T -- the text string to search for patterns.
    P -- the pattern string.
    """
    n=len(T)
    m=len(P)
    shift=[]
    for s in range(0, n-m+1):
        if P==T[s:s+m]:
            shift.append(s)
    return shift

def p_naive_string_matcher(T, P, cores=4) :
    """Parallel naive string matcher algorithm from Problem Set 4.

    This function implements the parallel naive string matcher algorithm that you specified in
    Problem Set 4.  You may assume in your implementation that there are 4 processor cores.
    If you want to write this more generally, you may add a parameter to the function for number
    of processes.  If you do, don't change the order of the existing parameters, and your new parameters
    must follow, and must have default values such that if the only parameters I pass are T and P, that
    you default to 4 processes.

    Like the sequential implementation from step 1 of assignment, this function should not
    print results.  Instead, have it return a list of the indices where the matches begin.
    For example, if T="abcabcabc" and P="def", this function
    will return the empty list [] since the pattern doesn't appear in T.
    For that same T, if the pattern P="abc", then this function will return
    the list [0, 3, 6] since the pattern appears 3 times, beginning on indices
    0, 3, and 6.

    You must use Process objects (or a Pool of processes) from the multiprocessing module and not Threads from threading because
    in the next step of the assignment, you're going to investigate performance relative to the sequential
    implementation.  And due to Python's global interpreter lock, you won't see any gain if you use threads.
    I recommend using a Pool, and its map method.

    Hints related to using Pool.map: 1) You'll need a function of one argument
    to pass to Pool.map, and a list of the values for that argument.  This list can be a list of the starting indices
    to check for matches (i.e., the indices from the outer loop of the naive string matcher).  The one argument function's
    one argument can be the index to check, and can then check if a match starts at that index. 2) But wait, wouldn't that
    function need 3 arguments, T, P, and the index? Yes. Start by creating a helper function with those 3 arguments, with
    index as the last argument.  Your helper can simply return a boolean indicating whether it is a match.
    Then, look up the documentation for a function named partial in the Python module functools.
    partial takes as arguments a function and some of the arguments for it, and returns to you a function where those arguments
    will be passed by default.  E.g., you can pass your helper function, and T and P to partial, and it will return to you a
    function that you simply need to pass index (the remaining argument).  3) Your last hint.  If you follow hints 1 and 2, you'll
    end up with a list of booleans, true if that corresponding index was a match and false otherwise.  The final step would
    be to use that to generate what this string matcher is actually supposed to return.

    Keyword arguments:s
    T -- the text string to search for patterns.
    P -- the pattern string.
    """

    n=len(T)
    m=len(P)
    shift=[]
    iterable = list(range(0,n-m+1))
    func = partial(match, text=T, pattern=P)
    with Pool(cores) as p:
        p_map=p.map(func, iterable)
        
    map_length=len(p_map)
    for i in range(map_length):
        if p_map[i]==True:
            shift.append(i)
    return shift

def match(index, text, pattern):
    m=len(pattern)
    if pattern==text[index:index+m]:
        return True
    return False


if __name__ == "__main__":

    print(naive_string_matcher("abcabcabc", "abc"))
    print(p_naive_string_matcher("abcabcabc", "abc"))
    time_results()
    
