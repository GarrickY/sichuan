package com.ygq.jobs.json;

import com.sun.tracing.ProbeName;
import org.json.JSONString;

import java.util.ArrayList;

public class CmsContent {

     public General general;
    public Theme theme;
    public FeatureContent feature_content;  //should be feature-content
    public ArrayList<Navigation> navigation;

    public class General{
        public String homepage_action;   //should be homepage-action
        public String homepage;
        public String cmsVersion;
        public String appName;
    }

    public class Theme{
        public String themeName;
        public String bgColor;
        public String logoImage;
        public String bgOpaqueness;

    }

    public class FeatureContent{
        public ArrayList<Categories> categories;

        public class Categories{

            public String feature_id;    //should be feature-id
            public String title;
            public String template;
            public ArrayList<Item> items;

            public class Item{
                public String feature_id;   //should be feature-id
                public String template;
                public String image;
                public String title;
                public String friendlyName;
                public String description;
                public String action_label;    //should be action-label
                public String action_command;   //should be action-command
            }
        }
    }

    public class Navigation{

        public String menuId;
        public ArrayList<Item> items;

        public class Item{
            public String label;
            public String id;
            public String iconAsChar;
            public String action;
            public String friendlyName;
            public ArrayList<Items> items;

            public class Items{
                public String label;
                public String id;
                public String action;
                public String friendlyName;
            }
        }
    }
}