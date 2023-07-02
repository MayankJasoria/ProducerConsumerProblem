# Producer Consumer | Bounded Queue Problem
There are p producer and c consumers of a buffer. Produces publishes data to the buffer while consumer consumes data
from the buffer. In this solution, two different approaches for using a blocking queue have been used.
## 1. Monitor based
This approach uses `synchronized` and `wait()`, `notifyAll()` to manage thread states within the `MonitorBlockingQueue`
instance.

## 2. Semaphore based
A `Semaphore` class having max permits has been defined. `release()` of permits beyond max requires threads to be
blocked till available permits becomes less. Similarly, acquiring more permits when 0 are available causes threads to
be blocked till more permits become available. A `SemaphoreBlockingQueue` class has been implemented that achieves the
same behaviour as [1. Monitor based](#1-monitor-based), but uses semaphores instead of monitor.

## Sample Run
```
Testing with monitor queue: 
Created 5 producers and 11 consumers to use a blocking queue of size 1
Consumer-1 consumed 2229
Producer-1 produced data 2229
Consumer-11 consumed 5737
Producer-2 produced data 5737
Producer-3 produced data 1446
Consumer-2 consumed 1446
Producer-4 produced data 3238
Consumer-10 consumed 3238
Producer-5 produced data 7827
Consumer-3 consumed 7827
Consumer-4 consumed 7070
Producer-3 produced data 7070
Consumer-2 consumed 2471
Producer-2 produced data 2471
Consumer-10 consumed 2966
Producer-1 produced data 2966
Consumer-3 consumed 2958
Producer-5 produced data 2958
Consumer-10 consumed 5616
Producer-1 produced data 5616
Consumer-1 consumed 7837
Producer-4 produced data 7837
Consumer-3 consumed 5475
Producer-2 produced data 5475
Consumer-1 consumed 4966
Producer-3 produced data 4966
Consumer-2 consumed 3897
Producer-3 produced data 3897
Consumer-10 consumed 99
Producer-5 produced data 99
Producer-2 produced data 6755
Consumer-4 consumed 6755
Producer-1 produced data 9972
Consumer-1 consumed 9972
Consumer-2 consumed 3314
Producer-4 produced data 3314
Consumer-11 consumed 1706
Producer-1 produced data 1706
Producer-4 produced data 2788
Consumer-1 consumed 2788
Consumer-4 consumed 2059
Producer-3 produced data 2059
Producer-4 produced data 9368
Consumer-1 consumed 9368
Consumer-2 consumed 5258
Producer-5 produced data 5258
Producer-3 produced data 5928
Consumer-11 consumed 5928
Producer-2 produced data 7493
Consumer-9 consumed 7493
Consumer-10 consumed 715
Producer-1 produced data 715
Producer-5 produced data 5260
Consumer-11 consumed 5260
Producer-3 produced data 4386
Consumer-3 consumed 4386
Consumer-2 consumed 2487
Producer-3 produced data 2487
Producer-2 produced data 415
Consumer-9 consumed 415
Consumer-2 consumed 8397
Producer-4 produced data 8397
Producer-3 produced data 5521
Consumer-10 consumed 5521
Producer-2 produced data 5196
Consumer-11 consumed 5196
Producer-3 produced data 2548
Consumer-5 consumed 2548
Consumer-11 consumed 6121
Producer-1 produced data 6121
Producer-5 produced data 4361
Consumer-10 consumed 4361
Producer-4 produced data 2881
Consumer-2 consumed 2881
Consumer-11 consumed 2974
Producer-2 produced data 2974
Producer-3 produced data 9397
Consumer-3 consumed 9397
Producer-4 produced data 1568
Consumer-10 consumed 1568
Producer-3 produced data 5427
Consumer-4 consumed 5427
Consumer-2 consumed 2035
Producer-1 produced data 2035
Producer-5 produced data 9484
Consumer-1 consumed 9484
Producer-1 produced data 3249
Consumer-9 consumed 3249
Producer-5 produced data 2207
Consumer-3 consumed 2207
Producer-2 produced data 6396
Consumer-5 consumed 6396
Producer-3 produced data 7096
Consumer-2 consumed 7096
Producer-5 produced data 8343
Consumer-11 consumed 8343
Producer-4 produced data 4284
Consumer-3 consumed 4284
Producer-5 produced data 1817
Consumer-11 consumed 1817
Producer-3 produced data 248
Consumer-1 consumed 248
Producer-2 produced data 5032
Consumer-2 consumed 5032
Producer-1 produced data 9249
Consumer-11 consumed 9249
Producer-1 produced data 8009
Consumer-3 consumed 8009
Producer-5 produced data 1408
Consumer-2 consumed 1408
Producer-3 produced data 7064
Consumer-1 consumed 7064
Producer-2 produced data 2621
Consumer-8 consumed 2621
Producer-1 produced data 3358
Consumer-11 consumed 3358
Producer-3 produced data 6020
Consumer-2 consumed 6020
Producer-4 produced data 7683
Consumer-1 consumed 7683
Producer-3 produced data 5082
Consumer-3 consumed 5082
Producer-2 produced data 6139
Consumer-11 consumed 6139
Producer-3 produced data 9678
Consumer-8 consumed 9678
Producer-5 produced data 9173
Consumer-5 consumed 9173
Producer-1 produced data 2617
Consumer-3 consumed 2617
Producer-5 produced data 1898
Consumer-11 consumed 1898
Consumer-2 consumed 9230
Producer-4 produced data 9230
Producer-4 produced data 3514
Consumer-5 consumed 3514
Producer-3 produced data 6974
Consumer-7 consumed 6974
Producer-1 produced data 284
Consumer-8 consumed 284
Consumer-3 consumed 8998
Producer-2 produced data 8998
Consumer-1 consumed 8655
Producer-4 produced data 8655
Producer-3 produced data 2621
Consumer-11 consumed 2621
Consumer-1 consumed 4343
Producer-5 produced data 4343
Producer-3 produced data 2842
Consumer-2 consumed 2842
Producer-4 produced data 5736
Consumer-11 consumed 5736
Producer-2 produced data 6933
Consumer-6 consumed 6933
Producer-1 produced data 3548
Consumer-11 consumed 3548
Consumer-4 consumed 9042
Producer-5 produced data 9042
Producer-3 produced data 925
Consumer-6 consumed 925
Producer-1 produced data 8078
Consumer-10 consumed 8078
Producer-4 produced data 5959
Consumer-11 consumed 5959
Producer-2 produced data 7421
Consumer-9 consumed 7421
Consumer-2 consumed 74
Producer-4 produced data 74
Producer-1 produced data 463
Consumer-9 consumed 463
Consumer-1 consumed 5559
Producer-5 produced data 5559
Producer-3 produced data 3868
Consumer-2 consumed 3868
Producer-4 produced data 9184
Consumer-11 consumed 9184
Producer-2 produced data 1233
Consumer-9 consumed 1233
Producer-5 produced data 1671
Consumer-3 consumed 1671
Producer-1 produced data 861
Consumer-2 consumed 861
Producer-5 produced data 8301
Consumer-7 consumed 8301
Producer-3 produced data 917
Consumer-1 consumed 917
Consumer-3 consumed 5561
Producer-2 produced data 5561
Producer-5 produced data 621
Consumer-9 consumed 621
Producer-4 produced data 8307
Consumer-1 consumed 8307
Producer-1 produced data 5792
Consumer-7 consumed 5792
Producer-1 produced data 1370
Consumer-11 consumed 1370
Terminating thread Producer-2 due to interrupt
Terminating thread Producer-4 due to interrupt
Terminating thread Producer-3 due to interrupt
Terminating thread Producer-1 due to interrupt
Terminating thread Producer-5 due to interrupt
Terminating thread Consumer-1 due to interrupt
Terminating thread Consumer-7 due to interrupt
Terminating thread Consumer-3 due to interrupt
Terminating thread Consumer-6 due to interrupt
Terminating thread Consumer-5 due to interrupt
Terminating thread Consumer-8 due to interrupt
Terminating thread Consumer-4 due to interrupt
Terminating thread Consumer-9 due to interrupt
Terminating thread Consumer-2 due to interrupt
Terminating thread Consumer-10 due to interrupt
Terminating thread Consumer-11 due to interrupt
All threads have been terminated.

Testing with semaphore queue: 
Created 5 producers and 11 consumers to use a blocking queue of size 1
Producer-1 produced data 4448
Consumer-1 consumed 4448
Producer-3 produced data 6316
Consumer-3 consumed 6316
Producer-2 produced data 758
Consumer-5 consumed 758
Producer-4 produced data 2115
Consumer-7 consumed 2115
Producer-5 produced data 3822
Consumer-9 consumed 3822
Producer-5 produced data 8762
Consumer-11 consumed 8762
Producer-2 produced data 8135
Consumer-4 consumed 8135
Producer-4 produced data 3616
Consumer-8 consumed 3616
Producer-1 produced data 1156
Consumer-7 consumed 1156
Producer-3 produced data 2561
Consumer-9 consumed 2561
Producer-5 produced data 7277
Consumer-2 consumed 7277
Consumer-3 consumed 9253
Producer-2 produced data 9253
Producer-1 produced data 1892
Consumer-4 consumed 1892
Producer-4 produced data 2254
Consumer-8 consumed 2254
Producer-3 produced data 9565
Consumer-5 consumed 9565
Producer-2 produced data 5344
Consumer-7 consumed 5344
Producer-4 produced data 8589
Consumer-10 consumed 8589
Producer-5 produced data 4162
Consumer-3 consumed 4162
Consumer-11 consumed 502
Producer-2 produced data 502
Producer-4 produced data 9892
Consumer-4 consumed 9892
Producer-3 produced data 6099
Consumer-5 consumed 6099
Producer-2 produced data 7896
Consumer-2 consumed 7896
Producer-1 produced data 1479
Consumer-9 consumed 1479
Producer-2 produced data 1840
Consumer-6 consumed 1840
Producer-5 produced data 7962
Consumer-11 consumed 7962
Producer-4 produced data 129
Consumer-5 consumed 129
Producer-3 produced data 1756
Consumer-7 consumed 1756
Producer-5 produced data 4558
Consumer-3 consumed 4558
Producer-2 produced data 5842
Consumer-2 consumed 5842
Producer-1 produced data 4238
Consumer-6 consumed 4238
Producer-5 produced data 2829
Consumer-8 consumed 2829
Producer-3 produced data 9581
Consumer-4 consumed 9581
Producer-1 produced data 3105
Consumer-10 consumed 3105
Producer-4 produced data 9314
Consumer-11 consumed 9314
Producer-2 produced data 8198
Consumer-5 consumed 8198
Producer-5 produced data 6752
Consumer-1 consumed 6752
Producer-3 produced data 9575
Consumer-3 consumed 9575
Producer-1 produced data 6164
Consumer-2 consumed 6164
Producer-2 produced data 2672
Consumer-7 consumed 2672
Producer-3 produced data 4323
Consumer-9 consumed 4323
Producer-4 produced data 5468
Consumer-1 consumed 5468
Producer-1 produced data 1722
Consumer-10 consumed 1722
Producer-3 produced data 555
Consumer-11 consumed 555
Consumer-3 consumed 5263
Producer-2 produced data 5263
Producer-4 produced data 5049
Consumer-4 consumed 5049
Producer-5 produced data 6051
Consumer-7 consumed 6051
Producer-2 produced data 6533
Consumer-9 consumed 6533
Producer-5 produced data 235
Consumer-5 consumed 235
Producer-1 produced data 3008
Consumer-8 consumed 3008
Producer-3 produced data 1870
Consumer-6 consumed 1870
Producer-5 produced data 1067
Consumer-4 consumed 1067
Producer-1 produced data 5373
Consumer-3 consumed 5373
Producer-4 produced data 9373
Consumer-11 consumed 9373
Producer-2 produced data 4928
Consumer-2 consumed 4928
Producer-5 produced data 4195
Consumer-5 consumed 4195
Producer-3 produced data 6123
Consumer-8 consumed 6123
Producer-5 produced data 6602
Consumer-6 consumed 6602
Producer-4 produced data 9692
Consumer-10 consumed 9692
Producer-2 produced data 5396
Consumer-3 consumed 5396
Producer-1 produced data 1196
Consumer-1 consumed 1196
Producer-2 produced data 3441
Consumer-7 consumed 3441
Producer-5 produced data 5275
Consumer-8 consumed 5275
Producer-1 produced data 1554
Consumer-4 consumed 1554
Producer-3 produced data 2747
Consumer-5 consumed 2747
Producer-1 produced data 7571
Consumer-6 consumed 7571
Producer-4 produced data 5363
Consumer-9 consumed 5363
Producer-5 produced data 5333
Consumer-10 consumed 5333
Producer-2 produced data 9217
Consumer-7 consumed 9217
Producer-4 produced data 3235
Consumer-3 consumed 3235
Producer-2 produced data 3870
Consumer-6 consumed 3870
Producer-5 produced data 9943
Consumer-5 consumed 9943
Producer-3 produced data 5420
Consumer-1 consumed 5420
Consumer-10 consumed 6529
Producer-2 produced data 6529
Producer-1 produced data 8634
Consumer-4 consumed 8634
Producer-1 produced data 4948
Consumer-7 consumed 4948
Producer-4 produced data 8907
Consumer-3 consumed 8907
Producer-5 produced data 9283
Consumer-5 consumed 9283
Producer-3 produced data 9954
Consumer-11 consumed 9954
Producer-2 produced data 6684
Consumer-6 consumed 6684
Producer-1 produced data 6155
Consumer-10 consumed 6155
Producer-4 produced data 8789
Consumer-9 consumed 8789
Producer-2 produced data 2234
Consumer-8 consumed 2234
Producer-5 produced data 7875
Consumer-1 consumed 7875
Producer-3 produced data 1463
Consumer-5 consumed 1463
Consumer-6 consumed 3266
Producer-2 produced data 3266
Producer-1 produced data 8286
Consumer-10 consumed 8286
Producer-2 produced data 1944
Consumer-7 consumed 1944
Producer-3 produced data 9107
Consumer-11 consumed 9107
Producer-4 produced data 6546
Consumer-8 consumed 6546
Producer-1 produced data 1661
Consumer-4 consumed 1661
Producer-5 produced data 9986
Consumer-3 consumed 9986
Producer-4 produced data 8454
Consumer-9 consumed 8454
Producer-2 produced data 825
Consumer-10 consumed 825
Terminating thread Producer-3 due to interrupt
Terminating thread Producer-5 due to interrupt
Terminating thread Producer-2 due to interrupt
Terminating thread Producer-4 due to interrupt
Terminating thread Producer-1 due to interrupt
Terminating thread Consumer-1 due to interrupt
Terminating thread Consumer-7 due to interrupt
Terminating thread Consumer-4 due to interrupt
Terminating thread Consumer-8 due to interrupt
Terminating thread Consumer-6 due to interrupt
Terminating thread Consumer-5 due to interrupt
Terminating thread Consumer-3 due to interrupt
Terminating thread Consumer-2 due to interrupt
Terminating thread Consumer-9 due to interrupt
Terminating thread Consumer-10 due to interrupt
Terminating thread Consumer-11 due to interrupt
All threads have been terminated.
```