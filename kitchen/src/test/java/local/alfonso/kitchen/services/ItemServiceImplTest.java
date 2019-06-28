package local.alfonso.kitchen.services;

import local.alfonso.kitchen.KitchenApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KitchenApplication.class)
public class ItemServiceImplTest
{
    @Autowired
    private ItemService itemService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void findItemsByCategory()
    {
    }

    @Test
    public void findByUserId()
    {
    }

    @Test
    public void findAll()
    {
        assertEquals(30, itemService.findAll().size());
    }

    @Test
    public void findItemById()
    {
        assertEquals("beef", itemService.findItemById(22).getItemname());
    }

    @Test(expected = EntityNotFoundException.class)
    public void findItemByIdNo()
    {
        assertEquals("Lambda", itemService.findItemById(3000).getItemname());
    }

    @Test
    public void delete()
    {
        itemService.delete(25);
        assertEquals(45, itemService.findAll().size());
    }

    @Test
    public void save()
    {
    }

    @Test
    public void update()
    {
    }
}