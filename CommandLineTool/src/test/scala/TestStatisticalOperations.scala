import org.scalatest.FunSuite

class TestStatisticalOperations extends FunSuite {
  test("An empty Set should have size 0") {
    assert(Set.empty.isEmpty)
  }
  test("Invoking head on an empty Set should produce NoSuchElementException") {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }
  test("test Min ") {
    val testdata = Array[Double](1, 2, 3, 4)
    val result = StatisticalOperations.findMin(testdata)
    assert(result == 1)
  }

  test("test with Double ") {
    val testdata = Array[Double](1, 2.45, 3, 4)
    val result = StatisticalOperations.findMin(testdata)
    assert(result == 1)
  }

  test("Big Double ") {
    val testdata = Array[Double](134.345245, 2.45, 323423534634565475474.4, 4)
    val result = StatisticalOperations.findMin(testdata)
    assert(result == 2.45)
  }
  test("Min decimal round to 2 digits ") {
    val testdata = Array[Double](134.345245, 2.45436, 323423534634565475474.4, 4)
    val result = StatisticalOperations.findMin(testdata)
    assert(result == 2.45436)
  }

  test("Max Big Double ") {
    val testdata = Array[Double](134.345245, 2.45, 323423534634565475474.4, 4)
    val result = StatisticalOperations.findMax(testdata)
    assert(result == 323423534634565475474.4)
  }

  test("test max ") {
    val testdata = Array[Double](1, 2, 3, 4)
    val result = StatisticalOperations.findMax(testdata)
    assert(result == 4)
  }
  test("test max with Double ") {
    val testdata = Array[Double](1, 2.45, 3, 4)
    val result = StatisticalOperations.findMax(testdata)
    assert(result == 4)
  }


  test("test Mean ") {
    val testdata = Array[Double](1, 2, 3, 4)
    val result = StatisticalOperations.findMean(testdata)
    assert(result == 2.50)
  }
  test("test Mean with Double ") {
    val testdata = Array[Double](1, 2.45, 3, 4)
    val result = StatisticalOperations.findMean(testdata)
    assert(result == 2.61)
  }
  test("test Mean with Big  ") {
    val testdata = Array[Double](134.345245, 2.45, 323423534634565475474.4, 4)
    val result = StatisticalOperations.findMean(testdata)
    assert(result == 80855883658641380000.00)
  }
  test("test Mean with Big Double ") {
    val testdata = Array[Double](134.345245, 2.45, 323423534634565475474.44645777, 4)
    val result = StatisticalOperations.findMean(testdata)
    assert(result == 80855883658641380000.00)
  }


  test("test Median ") {
    val testdata = Array[Double](1, 2, 3, 4)
    val result = StatisticalOperations.findMedian(testdata)
    assert(result == 2.50)
  }
  test("test Median with Double ") {
    val testdata = Array[Double](1, 2.45, 3, 4,6)
    val result = StatisticalOperations.findMedian(testdata)
    assert(result == 3.00)
  }
  test("test Median with Big  ") {
    val testdata = Array[Double](134.345245, 2.45, 323423534634565475474.4, 4)
    val result = StatisticalOperations.findMedian(testdata)
    assert(result == 69.17)
  }
  test("test Median with Big Double ") {
    val testdata = Array[Double](134.345245, 2.45, 323423534634565475474.4, 4)
    val result = StatisticalOperations.findMedian(testdata)
    assert(result == 69.17)
  }


  test("test Mode ") {
    val testdata = Array[Double](1, 2, 3, 4, 4, 4, 4, 5, 6, 23, 3)
    val result = StatisticalOperations.findMode(testdata)
    assert(result == 4)
  }
  test("test Mode with Double ") {
    val testdata = Array[Double](1, 2.45, 3, 4, 2.45, 2.45, 2.45, 2.45)
    val result = StatisticalOperations.findMode(testdata)
    assert(result == 2.45)
  }
  test("test Mode with Big  ") {
    val testdata = Array[Double](134.345245, 2.45, 323423534634565475474.4)
    val result = StatisticalOperations.findMode(testdata)
    assert(result == 2.45)
  }
  test("test Mode with Big Double ") {
    val testdata = Array[Double](134.345245, 2.45, 323423534634565475474.8, 4, 2.45, 323423534634565475474.8)
    val result = StatisticalOperations.findMode(testdata)
    assert(result == 2.45)
  }


  test("test Standard Deviation ") {
    val testdata = Array[Double](1, 2, 3, 4)
    val result = StatisticalOperations.findStdDev(testdata)
    assert(result == 1.12)
  }
  test("test Standard Deviation with Double ") {
    val testdata = Array[Double](1, 2.45, 3, 4)
    val result = StatisticalOperations.findStdDev(testdata)
    assert(result == 1.08)
  }
  test("test Standard Deviation with Long  ") {
    val testdata = Array[Double](134.345245, 2.45, 3234235346L, 4)
    val result = StatisticalOperations.findStdDev(testdata)
    assert(result == 1400464965.40)
  }
  test("test Standard Deviation with Big Double ") {
    val testdata = Array[Double](134.345245, 2.45, 323423534634565475474.4, 4)
    val result = StatisticalOperations.findStdDev(testdata)
    assert(result == 140046498587644990000.00)
  }


  test("test Count ") {
    val testdata = Array[Double](1, 2, 3, 4)
    val result = StatisticalOperations.findCount(testdata)
    assert(result == 4)
  }
  test("test Count with Double ") {
    val testdata = Array[Double](1, 2.45, 3, 4, 7)
    val result = StatisticalOperations.findCount(testdata)
    assert(result == 5)
  }
  test("test Count with Big  ") {
    val testdata = Array[Double](134.345245, 2.45, 323423534634565475474.4, 4)
    val result = StatisticalOperations.findCount(testdata)
    assert(result == 4)
  }
  test("test Count with Big Double ") {
    val testdata = Array[Double](134.345245, 2.45, 323423534634565475474.4, 4)
    val result = StatisticalOperations.findCount(testdata)
    assert(result == 4)
  }


  test("test Variance ") {
    val testdata = Array[Double](1, 2, 3, 4)
    val result = StatisticalOperations.findVariance(testdata)
    assert(result == 1.25)
  }
  test("test Variance with Double ") {
    val testdata = Array[Double](1, 2.45, 3, 4, 7)
    val result = StatisticalOperations.findVariance(testdata)
    assert(result == 4.02)
  }
  test("test variance with Big Double ") {
    val testdata = Array[Double](134.345245, 2.45, 3224.46087, 4)
    val result = StatisticalOperations.findVariance(testdata)
    assert(result == 1895995.34)
  }


  test("test Harmonic Mean with Big Double ") {
    val testdata = Array[Double](1, 2, 3, 4)
    val result = StatisticalOperations.findHarmonicMean(testdata)
    assert(result == 1.92)
  }
  test("test Harmonic with Double ") {
    val testdata = Array[Double](1, 2.45, 3, 4, 7)
    val result = StatisticalOperations.findHarmonicMean(testdata)
    assert(result == 2.34)
  }
  test("test Harmonic with Big  ") {
    val testdata = Array[Double](134.345245, 2.45, 3234235346L, 4)
    val result = StatisticalOperations.findHarmonicMean(testdata)
    assert(result == 6.01)
  }
  test("test Harmonic with Big Double ") {
    val testdata = Array[Double](134.345245, 2.45, 3234235346.4677777, 4)
    val result = StatisticalOperations.findHarmonicMean(testdata)
    assert(result == 6.01)
  }




  test("test Geometric Mean with Big Double ") {
    val testdata = Array[Double](1, 2, 3, 4)
    val result = StatisticalOperations.findGeometricMean(testdata)
    assert(result == 2.21)
  }
  test("test Geometric with Double ") {
    val testdata = Array[Double](1, 2.45, 3, 4, 7)
    val result = StatisticalOperations.findGeometricMean(testdata)
    assert(result == 2.90)
  }
  test("test Geometric with Big  ") {
    val testdata = Array[Double](134.345245, 2.45, 3234235346L, 4)
    val result = StatisticalOperations.findGeometricMean(testdata)
    assert(result == 1436.50)
  }
  test("test Geometric with Big Double ") {
    val testdata = Array[Double](134.345245, 2.45, 3234235346.4677777, 4)
    val result = StatisticalOperations.findGeometricMean(testdata)
    assert(result == 1436.50)
  }




}
