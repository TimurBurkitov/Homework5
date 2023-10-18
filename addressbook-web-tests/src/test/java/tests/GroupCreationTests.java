package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {


    public int id;

    @Test
  public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupsHelper().getGroupList();
        GroupData group = new GroupData(id, "test1", null, null);
        app.getGroupsHelper().createGroup(group);
        List<GroupData> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);


        int max = 0;
        for (GroupData g : after) {
            if (g.getId() >max) {
                max = g.getId();
            }
        }
        group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
