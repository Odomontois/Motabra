package web.srv

import javax.servlet.annotation.WebServlet
import db.util.record.TestEntity

/**
 * Created with IntelliJ IDEA.
 * User: odomontois
 * Date: 10.09.12
 * Time: 13:49
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "TestEntity", urlPatterns = Array("/test/entities/new"))
class TestEntityRestNew extends EntityRestServlet(TestEntity)
