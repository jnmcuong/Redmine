package com.ini.xfn.nmcuong.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.event.ListSelectionEvent;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.JavaScriptUtils;

import com.ini.xfn.nmcuong.domain.Issue;
import com.ini.xfn.nmcuong.model.IssueModel;
import com.ini.xfn.nmcuong.model.ParentTaskModel;
import com.ini.xfn.nmcuong.service.IssueService;
import com.ini.xfn.nmcuong.service.MemberService;
import com.ini.xfn.nmcuong.service.PriorityService;
import com.ini.xfn.nmcuong.service.ProjectService;
import com.ini.xfn.nmcuong.service.StatusService;
import com.ini.xfn.nmcuong.service.TrackerService;
import com.ini.xfn.nmcuong.service.UserService;

@Controller
@RequestMapping(value = "/issue")
public class IssueController {

    @Autowired(required = true)
    private IssueService issueService;

    @Autowired(required = true)
    private PriorityService priorityService;

    @Autowired(required = true)
    private TrackerService trackerService;

    @Autowired(required = true)
    private StatusService statusService;

    @Autowired(required = true)
    private MemberService memberService;

    @Autowired(required = true)
    private UserService userService;

    @Autowired(required = true)
    private ProjectService projectService;

    private int idProject = 1;

    @RequestMapping(value = "/view-all", method = RequestMethod.GET)
    public String viewAllIssue(Model model) {
        // priorityService.getById(1);
        // projectService.getById(1);
        // issueService.getAll();
        return "issues";
    }

    @ResponseBody
    @RequestMapping(value = "/getIssues", method = RequestMethod.GET)
    public List<IssueModel> getIssues() {
        return issueService.getAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String viewPageCreateIssue(Model model) {
        model.addAttribute("trackers", trackerService.getAll());
        model.addAttribute("status", statusService.getAll());
        model.addAttribute("priority", priorityService.getAll());
        model.addAttribute("members", memberService.getByProject(idProject));

        return "createIssue";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createIssue(Model model, HttpServletRequest request) {

        String[] watchers = request.getParameterValues("issue[watcher_user_ids][]");

        if (request instanceof MultipartHttpServletRequest) {
            String saveDirectory = "D:/uploads/";
            MultipartHttpServletRequest request2 = (MultipartHttpServletRequest) request;
            Iterator<String> itr = request2.getFileNames();
            while (itr.hasNext()) {
                MultipartFile file = request2.getFile(itr.next());
                System.out.println(file.getOriginalFilename() + " uploaded!");
                File serverFile = new File(saveDirectory + file.getOriginalFilename());
                BufferedOutputStream stream;

                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(bytes);
                    stream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        IssueModel issueModel = new IssueModel();
        issueModel.setTracker(Integer.parseInt(request.getParameter("tracker")));
        issueModel.setSubject(request.getParameter("subject"));
        issueModel.setDescription(request.getParameter("description"));
        issueModel.setStatus(Integer.parseInt(request.getParameter("status")));
        issueModel.setPriority(Integer.parseInt(request.getParameter("priority")));
        issueModel.setAssignee(Integer.parseInt(request.getParameter("assignee")));
        // issueModel.setCategory(Integer.parseInt(request.getParameter("category")));
        if (!request.getParameter("parent_issue").isEmpty())
            issueModel.setParentIssue(Integer.parseInt(request.getParameter("parent_issue")));

        issueModel.setStartDate(request.getParameter("start_date"));
        issueModel.setDueDate(request.getParameter("due_date"));

        issueModel.setEstimatedTime(Integer.parseInt(request.getParameter("estimated_hours")));
        issueModel.setPercentFinished(Integer.parseInt(request.getParameter("done_ratio")));
        issueModel.setMemberAdded(1);
        issueModel.setProject(idProject);
        issueService.save(issueModel);

        return viewPageCreateIssue(model);
    }

    @ResponseBody
    @RequestMapping(value = "/upload.js", method = RequestMethod.POST)
    public String upload(Model model, HttpServletRequest request) {

        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest request2 = (MultipartHttpServletRequest) request;
            Iterator<String> itr = request2.getFileNames();
            MultipartFile mpf = request2.getFile(itr.next());
            System.out.println(mpf.getOriginalFilename() + " uploaded!");
            // System.out.println(itr);
        }

        System.out.println(request.getParameter("attachment_id"));
        String str = "var fileSpan = $('#attachments_" + request.getParameter("attachment_id")
                + "');" + "$('<input>', { type: 'hidden', name: 'attachments["
                + request.getParameter("attachment_id")
                + "][token]' } ).val('2426.8de73d5791cc27eaad1c544c3042d31e').appendTo(fileSpan);"
                + "fileSpan.find('a.remove-upload')"
                + ".attr({\"data-remote\": true,\"data-method\": 'delete',"
                + "href: '/Redmine/issue/2426.js?attachment_id="
                + request.getParameter("attachment_id") + "'}).off('click');";
        return str;
    }

    @ResponseBody
    @RequestMapping(value = "/2426.js", method = RequestMethod.DELETE)
    public String deleteFile(Model model, HttpServletRequest request) {
        String str = "$('#attachments_" + request.getParameter("attachment_id") + "').remove();";
        return str;
    }

    @ResponseBody
    @RequestMapping(value = "/auto-complete", method = RequestMethod.GET)
    public List<ParentTaskModel> reponseIssueAutoComplete(
            @RequestParam(value = "term", required = true) String message) {
        // System.out.println(message);
        return issueService.getParentTask(idProject, message);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(Model model) {
        return "test";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(HttpServletRequest request) {
        if (request instanceof MultipartHttpServletRequest) {
            
        
//        System.out.println(request.getParameter("user"));
        Iterator<String> itr = ((MultipartHttpServletRequest) request).getFileNames();
        MultipartFile mpf = ((MultipartHttpServletRequest) request).getFile(itr.next());
        System.out.println(mpf.getOriginalFilename() + " uploaded!");
        }
        return "test";
    }
}
