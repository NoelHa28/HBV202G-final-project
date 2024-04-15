package is.hi.hbv202g.assignment8;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

    @RunWith(Suite.class)
    @SuiteClasses({ AuthorTest.class, BookTest.class, FacultyMemberTest.class, LibrarySystemTest.class, LendingTest.class, MainTest.class, StudentTest.class })
    public class Alltests {
    }