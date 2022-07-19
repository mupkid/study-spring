package org.ohx.studyspring.entity;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author mudkip
 * @date 2022/7/19
 */
public class MyFactoryBean implements FactoryBean<Course> {
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCourseName("Java");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
